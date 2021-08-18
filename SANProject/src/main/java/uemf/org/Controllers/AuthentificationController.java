package uemf.org.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uemf.org.Services.AuthentificationService;

@RestController
@RequestMapping("/apiAuth")

public class AuthentificationController {
	
	@Autowired
	AuthentificationService authentificationService;
	
	@PostMapping("/authUser")
	public String authUser(@RequestParam("login") String login, @RequestParam("passWord") String passWord )
	{
		System.out.println("****EXECUTION");
		String test= authentificationService.authUser(login, passWord);
	         System.out.println("*****************:   "+ test);
	   return 	test;
	}
	

}
