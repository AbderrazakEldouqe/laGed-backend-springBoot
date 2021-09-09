package uemf.org.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Exceptions.BadRequestException;
import uemf.org.Models.UserDTO;
import uemf.org.Repositories.UserRepository;
import uemf.org.Services.UserService;
import uemf.org.Transformers.UserTransformer;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTransformer userTransformer;

	@Override
	public UserDTO getUserById(Long id) {
		try {
			return userTransformer.entityToDTO(userRepository.getById(id));
		} catch (Exception e) {
			throw new BadRequestException(e.getMessage());
		}
	}




}
