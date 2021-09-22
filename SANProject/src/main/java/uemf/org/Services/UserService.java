package uemf.org.Services;

import uemf.org.Models.UserDTO;

public interface UserService {
	
	UserDTO getUserById(Long id);
	
	UserDTO getCurrentUser();


	

}
