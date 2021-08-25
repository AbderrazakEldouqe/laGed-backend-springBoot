package uemf.org.Models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class UserDTO  implements Serializable{

	private Long idUser;
	private String login;
	@JsonIgnore
	private String passWord;
	private String userFullNmae;
	private RoleDTO userRole;
	private Boolean rememberMe;
	
	

	
	
	
	
}
