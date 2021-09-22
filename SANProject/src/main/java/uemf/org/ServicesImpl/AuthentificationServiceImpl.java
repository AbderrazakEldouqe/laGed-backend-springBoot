package uemf.org.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Exceptions.BadRequestException;
import uemf.org.Exceptions.NotFoundException;
import uemf.org.Models.CustomUserDetailsDTO;
import uemf.org.Models.UserDTO;
import uemf.org.Repositories.UserRepository;
import uemf.org.Security.TokenProvider;
import uemf.org.Services.AuthentificationService;
import uemf.org.Transformers.UserTransformer;

@Service
@Slf4j
public class AuthentificationServiceImpl implements AuthentificationService , UserDetailsService {

	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    TokenProvider tokenProvider;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTransformer userTransformer;
	
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public CustomUserDetailsDTO authUser(String login, String passWord)
	{
		
		try {
			log.info("DEBUT DE LA METHODE authUser");

			/* for (UserEntity userEntity : userRepository.findAll()) 
				{
					userEntity.setPassWord(passwordEncoder.encode(userEntity.getPassWord()));
					userRepository.save(userEntity);
					System.out.println("Password:  "+userEntity.getPassWord());

				}
			*/
			

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login,passWord);
			Authentication authenticationRequest = authenticationManager.authenticate(authenticationToken);
			final CustomUserDetailsDTO userDetails =  (CustomUserDetailsDTO) loadUserByUsername(authenticationRequest.getName());
			SecurityContextHolder.getContext().setAuthentication(authenticationRequest);
			String jwtToken= tokenProvider.createToken(authenticationRequest , userDetails);
			userDetails.setJwtToken(jwtToken);
			log.info("FIN DE LA METHODE authUser");
			return  userDetails;
			
			//return  tokenProvider.createToken(authenticationRequest , userDetails);

		} catch (BadCredentialsException e) {
			
			log.error("Erreur auth : {}", e.getMessage());
			throw new NotFoundException("login.password.incorect");
		}
		 catch (DisabledException e) {
			 log.error("USER_DISABLED : {}", e.getMessage());
			 throw new BadRequestException("USER_DISABLED");
			}
	}


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
	{
		log.info("DEBUT DE LA METHODE loadUserByUsername");
		UserDTO userDTO =  userTransformer.entityToDTO(userRepository.findByLogin(login));
		
		if (userDTO == null) {
			log.error("User Login not found : {}", login);
			throw new NotFoundException("UserName " + login + " not found");
		}
		log.info("FIN DE LA METHODE loadUserByUsername");
		return new CustomUserDetailsDTO(userDTO);

	}



	
	
	
}
