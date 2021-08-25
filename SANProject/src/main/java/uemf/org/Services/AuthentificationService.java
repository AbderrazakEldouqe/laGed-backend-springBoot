package uemf.org.Services;

import uemf.org.Models.CustomUserDetailsDTO;

public interface AuthentificationService {
	
	
	//String authUser(UserDTO userDTO);
	
	CustomUserDetailsDTO authUser(String login, String passWord);
	
	
}
