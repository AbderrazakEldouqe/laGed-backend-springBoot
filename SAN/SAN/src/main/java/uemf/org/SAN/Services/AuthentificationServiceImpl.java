package uemf.org.SAN.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.authentication.AuthenticationManager;

import uemf.org.SAN.Models.UserDTO;
import uemf.org.SAN.Security.TokenProvider;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenProvider tokenProvider;
	
	
	public String authUser(UserDTO userDTO) {
		
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
					(userDTO.getLogin(), userDTO.getPassWord());

			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = tokenProvider.createToken(authentication , userDTO);
			return token;
		} catch (BadCredentialsException e) {
			//log.warn("Erreur auth : {}", e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "login.password.incorect");
		}
	}

}
