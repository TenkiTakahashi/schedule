package jp.ac.ohara.schedule.model;
 
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
 
@Data
public class SignupForm {
	@NotBlank
	private String studentnumber;
	@NotBlank
	private String password;
}