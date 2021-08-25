package uemf.org.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import uemf.org.Models.CustomUserDetailsDTO;
import uemf.org.Services.AuthentificationService;



@CrossOrigin("*")
@Api(value = "AuthentificationController", tags = { "Authentification Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Authentification Controller") })

@RestController
@RequestMapping("/apiAuth")
public class AuthentificationController {
	
	@Autowired
	AuthentificationService authentificationService;
	
	@ApiOperation(value = "auth User")
	@PostMapping("/authUser")
	public ResponseEntity<CustomUserDetailsDTO> authUser(@RequestParam("login") String login, @RequestParam("passWord") String passWord )
	{	
		return  new ResponseEntity<CustomUserDetailsDTO>(authentificationService.authUser(login, passWord), HttpStatus.OK) ;
	   
	}
	
	


	

	
}
