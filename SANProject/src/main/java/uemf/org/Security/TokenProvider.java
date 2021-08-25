package uemf.org.Security;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.CustomUserDetailsDTO;
import uemf.org.Models.UserDTO;


@Component
@Slf4j
public class TokenProvider implements Serializable{

	
	@Value("${app.security.secret-key}")
	private String secretKey;





	public String createToken(String authorities, CustomUserDetailsDTO userDetails) {
		Map<String, Object> claims = new HashMap<>();
		
		if (claims != null) {
			
			claims.put(SecurityConstants.AUTHORITIES_KEY, authorities);
			claims.put(SecurityConstants.ID_USER, userDetails.getIdUser());
			claims.put(SecurityConstants.User_NAME, userDetails.getUsername());
			claims.put(SecurityConstants.User_ROLE, userDetails.getUserRole());

		}
	
		JwtBuilder jwtBuilder = Jwts.builder().setClaims(claims)
				                .setSubject(userDetails.getUsername())
				                .setIssuedAt(new Date(System.currentTimeMillis()))
				            	.setExpiration(new Date(System.currentTimeMillis() + 360*1000))
				            	.signWith(SignatureAlgorithm.HS512, secretKey);
		
		
		return jwtBuilder.compact();
		
   	}

	public String createToken(Authentication authentication, CustomUserDetailsDTO userDetails) {
		String authorities = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		return createToken(authorities, userDetails);
	}
	

	public Claims parse(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

	
	public Authentication getAuthentication(String token) {
		Claims claims = parse(token);
		Object auths = claims.get(SecurityConstants.AUTHORITIES_KEY);
		Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (!ObjectUtils.isEmpty(auths)) {
			authorities = Arrays
					.stream(auths.toString().split(","))
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
		}
		User principal = new User(claims.getSubject(), "", authorities);
		return new UsernamePasswordAuthenticationToken(principal, null, authorities);
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		} catch (Exception e) {

			log.debug("Invalid JWT token : {}", e.getMessage());
		}
		return false;
	}
	
	
	
	
	public String getUsernameFromToken(String token) {
		// TODO Auto-generated method stub
		final Claims claims =  Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		 String username = claims.getSubject();
		 return username;
	}
	
	
}
