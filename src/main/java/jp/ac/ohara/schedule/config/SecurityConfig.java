package jp.ac.ohara.schedule.config;
 
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jp.ac.ohara.schedule.model.ScheduleBook;
import jp.ac.ohara.schedule.repository.ScheduleBookRepository;
import jp.ac.ohara.schedule.service.LoginService;
 
 
@Configuration
 
@EnableWebSecurity
 
public class SecurityConfig {
 
	@Autowired
 
	private DataSource dataSource;
 
	@Autowired
 
	private LoginService userService;
	
	@Autowired
	private ScheduleBookRepository userRepository;
	
 
	@Bean

	
	UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager jdbcManager = new JdbcUserDetailsManager(this.dataSource);
 
		// TODO: あとで削除
		//this.userRepository.saveAndFlush(this.makeUser("2347056", "2347056"));
 
		return jdbcManager;
	}
 
	// TODO: あとで削除
	private ScheduleBook makeUser(String studentnumber, String password) {
		ScheduleBook record = new ScheduleBook();
		record.setStudentnumber(studentnumber);
		record.setPassword(this.passwordEncoder().encode(password));
		return record;
	}
	@Bean
 
	public BCryptPasswordEncoder passwordEncoder() {
 
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
 
		return bCryptPasswordEncoder;
 
	}
 
    @Bean
 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 
		http.httpBasic(
 
			(basic) ->
 
			basic.disable())
 
			.authorizeHttpRequests(request -> {
 
				request
 
						//ログインされていなくても表示できる
 
						.requestMatchers("/").permitAll()     // ログインページは全許可
 
						.requestMatchers("/signup/").permitAll()  // 新規登録ページは全許可
 
						.requestMatchers("/signupcomplete/").permitAll() // 登録完了ページは全許可
 
						.requestMatchers("/js/**").permitAll()      // JSのstaticファイル
 
						.requestMatchers("/css/**").permitAll()     // CSSのstaticファイル
 
						.requestMatchers("/images/**").permitAll()  // 画像のstaticファイル
 
						.anyRequest().authenticated();              // それ以外は認証必須
 
			})
 
			.formLogin(form -> {
 
				form
 
						//ログインしていないと表示されない
 
						.loginPage("/")             // ログインページのURI
 
						.loginProcessingUrl("/")    // ログインを実施するページのURI
 
						.defaultSuccessUrl("/top/") //ログイン成功時の遷移先
 
						.usernameParameter("studentnumber") // ログインユーザのname属性
 
						.passwordParameter("password");   // ログインパスワードのname属性
 
			})
 
			.userDetailsService(this.userService)
 
			.logout(logout -> {
 
				logout
 
						.logoutUrl("/logout/")
 
						.logoutSuccessUrl("/login/")
 
						.deleteCookies("JSESSIONID")
 
						.invalidateHttpSession(true);
 
			});
 
		return http.build();
 
	}
 
}
 