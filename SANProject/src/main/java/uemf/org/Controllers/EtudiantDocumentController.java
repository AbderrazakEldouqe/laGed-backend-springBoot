package uemf.org.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import uemf.org.Models.EtudiantDocumentDTO;
import uemf.org.Services.EtudiantDocumentService;

@CrossOrigin("*")
@Api(value = "EtudiantDocumentController", tags = { "EtudiantDocument Controller" })
@SwaggerDefinition(tags = { @Tag(name = "EtudiantDocument Controller") })

@RestController
@RequestMapping("/apiEtudiantDocument")
public class EtudiantDocumentController {
	
	
	@Autowired
	EtudiantDocumentService etudiantDocumentService;
	
	@ApiOperation(value = "getAllAnneScolaires")
	@GetMapping("/getAllAnneScolaires")
	public List<String> getAllAnneScolaires()
	{
		return  etudiantDocumentService.getAllAnneScolaires();
	   
	}
	
	@ApiOperation(value = "getEtudiantDocumentCriteria")
	@GetMapping("/getEtudiantDocumentCriteria")
	public List<EtudiantDocumentDTO> getEtudiantDocumentCriteria(

			@RequestParam(name = "anneeScolaire" ,required=false) String anneeScolaire,

			@RequestParam(name = "typeDocument" ,required=false) String typeDocument,
			
			@RequestParam(name = "matriculeEtudiant" ,required=false) Long matriculeEtudiant,

			@RequestParam(name = "nomEtudiant" ,required=false) String nomEtudiant){

		
		return etudiantDocumentService.getEtudiantDocumentCriteria(anneeScolaire, typeDocument, matriculeEtudiant, nomEtudiant);
	}

	@ApiOperation(value = "getCountAllDocuments")
	@GetMapping("/getCountAllDocuments")
	public Long getCountAllDocuments()
	{
		return  etudiantDocumentService.getCountAllDocuments();
	   
	}
	

	@ApiOperation(value = "getDocumentById")
	@GetMapping("/getDocumentById/{idDocument}")
	public EtudiantDocumentDTO getdocumentById(@PathVariable("idDocument") Long idDocument )
	{
		return   etudiantDocumentService.getDocumentById(idDocument);
	   
	}
	
	 @ApiOperation(value = "download File", response = ArrayList.class)
	    @GetMapping("/downloadFile")
	    public ResponseEntity<Resource> downloadFile(
	            @RequestParam(name = "idDocument", required = true) Long idDocument) throws Exception {
	        ResponseEntity<Resource> document = etudiantDocumentService.downloadFile(idDocument);
	        return document;
  }
	 
	  @ApiOperation(value = "upload file", response = String.class)
	    @PostMapping("/uplaodFiles")
	    public void uplaodFiles(@RequestBody  List<EtudiantDocumentDTO> listeEtudiantDocumentDTO)
	            throws Exception {
	  
	         try {
	              
	                etudiantDocumentService.uploadListFile(listeEtudiantDocumentDTO);
	 
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	                throw new Exception();
	            }
	    }
	  @ApiOperation(value = "getEtudiantDocumentByLastAnneScolaire")
		@GetMapping("/getEtudiantDocumentByLastAnneScolaire")
		public List<EtudiantDocumentDTO> getEtudiantDocumentByLastAnneScolaire()
		{
			return  etudiantDocumentService.getEtudiantDocumentByLastAnneScolaire();
		   
		}


}
