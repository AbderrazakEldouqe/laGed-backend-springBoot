package uemf.org.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import uemf.org.Models.EtudiantDTO;
import uemf.org.Services.EtudiantService;

@CrossOrigin("*")
@Api(value = "EtudiantController", tags = { "Etudiant Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Etudiant Controller") })

@RestController
@RequestMapping("/apiEtudiant")
public class EtudiantController {

	
	@Autowired
	EtudiantService etudiantService;
	
	@ApiOperation(value = "getCountAllEtudiants")
	@GetMapping("/getCountAllEtudiants")
	public Long getCountAllEtudiants()
	{
		return  etudiantService.getCountAllEtudiants();
	   
	}
	
	
	@ApiOperation(value = "getAllEtudiantByAnneScolaires")
	@GetMapping("/getAllEtudiantByAnneScolaires")
	public  List<EtudiantDTO>  getAllEtudiantByAnneScolaires(@RequestParam("anneeScolaire") String anneeScolaire)
	{
		return  etudiantService.getAllEtudiantByAnneScolaires(anneeScolaire);	   
	}
	
}
