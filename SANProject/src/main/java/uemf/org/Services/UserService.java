package uemf.org.Services;

import uemf.org.Models.UserDTO;

public interface UserService {

	UserDTO getUserByLoginAndPassWord(String login, String passWord);
	

}
