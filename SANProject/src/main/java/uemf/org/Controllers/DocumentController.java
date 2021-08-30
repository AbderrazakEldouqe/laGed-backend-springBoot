package uemf.org.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import uemf.org.Services.DocumentService;

@CrossOrigin("*")
@Api(value = "DocumentController", tags = { "Document Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Document Controller") })

@RestController
@RequestMapping("/apiDocument")
public class DocumentController {
	
	
	@Autowired
	DocumentService documentService;
	
	@ApiOperation(value = "getCountAllEtudiants")
	@GetMapping("/getCountAllEtudiants")
	public Long getCountAllEtudiants()
	{
		return  documentService.getCountAllDocuments();
	   
	}

}
