package jp.ac.ohara.schedule.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.ac.ohara.schedule.model.ScheduleBook;
import jp.ac.ohara.schedule.repository.ScheduleBookRepository;
@Service
 
public class LoginService implements UserDetailsService {
	@Autowired
 
	private ScheduleBookRepository scheduleBookRepository; // ユーザモデルのRepository
	/**
 
	 * ユーザの検索を行う
 
	 */
 
	@Override
 
	public UserDetails loadUserByUsername(String studentnumber) throws UsernameNotFoundException {
 
		System.out.println("serach studentnumber : " + studentnumber);
 
		ScheduleBook number = this.scheduleBookRepository.findBystudentnumberEquals(studentnumber); // emailで検索するので「EmailEquals」としている
 
		System.out.println(number.toString());
 
		return number;
 
	}
 
}