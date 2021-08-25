package uemf.org.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import uemf.org.Models.UserDTO;
import uemf.org.Services.UserService;

@CrossOrigin("*")
@Api(value = "UserController", tags = { "User Controller" })
@SwaggerDefinition(tags = { @Tag(name = "User Controller") })

@RestController
@RequestMapping("/apiUser")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "getUserById")
	@GetMapping("/getUserById/{idUser}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("idUser") Long idUser )
	{
		return  new ResponseEntity<UserDTO>(userService.getUserById(idUser), HttpStatus.OK) ;
	   
	}
	
}
