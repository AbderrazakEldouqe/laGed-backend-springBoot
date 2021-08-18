package uemf.org.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import uemf.org.Security.JwtRequestFilter;

@Configuration 
@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private  UserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	
   
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http
	        .csrf().disable()
	        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
	        .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	    .and()
			.authorizeRequests()
				.antMatchers(
						"/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/apiAuth/**"
						).permitAll()
				// Toutes les req nécessitent une auth
				.anyRequest().authenticated()
		.and().exceptionHandling() ;

	 }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
}
