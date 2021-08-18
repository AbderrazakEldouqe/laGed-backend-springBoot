package uemf.org.ServicesImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.AuthenticationManager;

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
	
	
	public String authUser(String login, String passWord) {
		
		UserDTO userDTO= userTransformer.entityToDTO(userRepository.findByLoginAndPassWord(login, passWord));

		if(userDTO == null)
			{
			log.warn("Erreur: UserDTO est null");
			  return null;
			}
		
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
					(login, passWord);

			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = tokenProvider.createToken(authentication , userDTO);
			return token;
		} catch (BadCredentialsException e) {
			log.warn("Erreur auth : {}", e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "login.password.incorect");
		}
	}


	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		UserDTO userDTO =  userTransformer.entityToDTO(userRepository.findByLogin(login));
		
		if(userDTO == null)
		{
			// a ajouter les exceptions
			log.warn("Erreur: UserDTO est null");
			return null;
		}
		else 
		{
			log.info("Utilisateur trouve dans la BD: {}", login);
			
		}
	    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		return new  org.springframework.security.core.userdetails.User(userDTO.getLogin(), userDTO.getPassWord(), authorities);

		

		
	}

}
