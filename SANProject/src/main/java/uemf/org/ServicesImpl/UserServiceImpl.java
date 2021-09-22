package uemf.org.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
			log.info("DEBUT DE LA METHODE getUserById :{}", id);
			return userTransformer.entityToDTO(userRepository.getById(id));
		} catch (Exception e)
		{
			log.error("ERROR HORS DE LA METHODE getUserById :{}", e.getMessage());
			throw new BadRequestException(e.getMessage());
		}
	}


	@Override
	public UserDTO getCurrentUser() {
		
		try {
			log.info("DEBUT DE LA METHODE getCurrentUser");
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = ((UserDetails)principal).getUsername();
			log.info(" getUserByLogin :{}", username);
			return  userTransformer.entityToDTO(userRepository.findByLogin(username));
		} catch (Exception e) {
			log.error("ERROR HORS DE LA METHODE getUserByLogin :{}", e.getMessage());
			throw new BadRequestException(e.getMessage());
		}
		
	}




}
