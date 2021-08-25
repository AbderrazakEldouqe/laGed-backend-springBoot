package uemf.org.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class CustomUserDetailsDTO  implements UserDetails,  Serializable
{

	private static final long serialVersionUID = 1L; 
	private Collection<? extends GrantedAuthority> authorities;
	//private UserDTO user; 
	private Long idUser;
	private String userName;
	private String fullUserName;
	private String userRole;
	private String passWord;
	private String jwtToken;

	

	public CustomUserDetailsDTO(UserDTO user) {
		super();
		
		this.idUser = user.getIdUser();
        this.userName=user.getLogin();
		this.fullUserName = user.getUserFullNmae();
		this.passWord = user.getPassWord();
		this.userRole = user.getUserRole().getRoleName();
		this.jwtToken = jwtToken;
		List<GrantedAuthority> authorities = new ArrayList<>(); 
		authorities.add(new SimpleGrantedAuthority(user.getUserRole().getRoleName().toUpperCase())); 
	} 
	

	@Override 
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		return authorities; 
	} 

	
	@Override 
	public boolean isAccountNonExpired() { 
		return true; 
	} 

	@Override 
	public boolean isAccountNonLocked() { 
		return true; 
	} 

	@Override 
	public boolean isCredentialsNonExpired() { 
		return true; 
	} 

	@Override 
	public boolean isEnabled() { 
		return true; 
	}



	@Override
	@JsonIgnore
	public String getPassword() {
		return this.passWord;
	}


	@Override
	public String getUsername() {
		return this.userName;
	}



}
