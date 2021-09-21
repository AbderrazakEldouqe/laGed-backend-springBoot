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
import uemf.org.Models.EtudiantDocumentAnnuleDTO;
import uemf.org.Services.EtudiantDocumentAnnuleService;

@CrossOrigin("*")
@Api(value = "EtudiantDocumentAnnuleController", tags = { "EtudiantDocumentAnnule Controller" })
@SwaggerDefinition(tags = { @Tag(name = "EtudiantDocumentAnnule Controller") })

 

@RestController
@RequestMapping("/apiEtudiantDocumentAnnule")
public class EtudiantDocumentAnnuleController {
	
	
	@Autowired
	EtudiantDocumentAnnuleService etudiantDocumentAnnuleService;
	
	@ApiOperation(value = "getEtudiantDocumentsAnnulesCriteria")
	@GetMapping("/getEtudiantDocumentsAnnulesCriteria")
	public List<EtudiantDocumentAnnuleDTO> getEtudiantDocumentsAnnulesCriteria(

			@RequestParam(name = "anneeScolaire" ,required=false) String anneeScolaire,

			@RequestParam(name = "typeDocument" ,required=false) String typeDocument,
			
			@RequestParam(name = "matriculeEtudiant" ,required=false) Long matriculeEtudiant,

			@RequestParam(name = "nomEtudiant" ,required=false) String nomEtudiant
			){

		
		return etudiantDocumentAnnuleService.getEtudiantDocumentAnnulesCriteria(anneeScolaire, typeDocument, matriculeEtudiant, nomEtudiant);
	}

}
