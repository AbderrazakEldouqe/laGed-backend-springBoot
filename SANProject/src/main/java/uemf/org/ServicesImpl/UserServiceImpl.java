package uemf.org.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.UserDTO;
import uemf.org.Repositories.UserRepository;
import uemf.org.Transformers.UserTransformer;
import uemf.org.Services.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTransformer userTransformer;

	@Override
	public UserDTO getUserByLoginAndPassWord(String login, String passWord) {
		
		return userTransformer.entityToDTO(userRepository.findByLoginAndPassWord(login, passWord));
	}




}
