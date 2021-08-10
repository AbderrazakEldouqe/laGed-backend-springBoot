package uemf.org.SAN.Models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class UserDTO  implements Serializable{

	private Long idUser;
	private String login;
	private String passWord;
	private String userFullNmae;
	private String userRole;
	private Boolean rememberMe;
	
	

	
	
	
	
}
