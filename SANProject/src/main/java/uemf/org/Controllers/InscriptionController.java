package uemf.org.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import uemf.org.Services.InscriptionService;


@CrossOrigin("*")
@Api(value = "InscriptionController", tags = { "Inscription Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Inscription Controller") })

@RestController
@RequestMapping("/apiInscription")
public class InscriptionController {

	@Autowired
	InscriptionService inscriptionService;
	
	
	
	@ApiOperation(value = "getAllAnneScolaires")
	@GetMapping("/getAllAnneScolaires")
	public List<String> getAllAnneScolaires()
	{
		return  inscriptionService.getAllAnneScolaires();
	   
	}
	
}
