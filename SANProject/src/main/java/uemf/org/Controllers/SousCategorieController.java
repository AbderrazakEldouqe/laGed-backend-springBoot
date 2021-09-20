package uemf.org.Controllers;

 

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import uemf.org.Models.CategorieDTO;
import uemf.org.Models.SousCategorieDTO;
import uemf.org.Services.CategorieService;
import uemf.org.Services.SousCategorieService;

 

@CrossOrigin("*")
@Api(value = "SousCategorieController", tags = { "SousCategorie Controller" })
@SwaggerDefinition(tags = { @Tag(name = "SousCategorie Controller") })

 

@RestController
@RequestMapping("/apiSousCategorie")
public class SousCategorieController {
    
    
    @Autowired
    SousCategorieService sousCategorieService;
    
    @ApiOperation(value = "saveSousCategorie")
    @PostMapping("/SousCategories")
    public SousCategorieDTO saveCategorie(@RequestBody SousCategorieDTO sousCategorieDTO)
    {
        return  sousCategorieService.saveSousCategorie(sousCategorieDTO);
       
    }
     
    @ApiOperation(value = "deleteSousCategorie")
    @DeleteMapping("/SousCategories/{idSousCategorie}")
    public void deleteSousCategorie(@PathVariable("idSousCategorie") Long idSousCategorie)
    {
          sousCategorieService.deleteSousCategorie(idSousCategorie);
    }
    
    
    @ApiOperation(value = "getSousCategorieById")
    @GetMapping("/SousCategories/{idSousCategorie}")
    public SousCategorieDTO getSousCategorieById(@PathVariable("idSousCategorie") Long idSousCategorie)
    {
        return  sousCategorieService.getSousCategorieById(idSousCategorie);
          
    }

    
    @ApiOperation(value = "updateSousCategories")
    @PutMapping("/SousCategories/{idSousCategorie}")
    public SousCategorieDTO updateSousCategorie(@RequestBody SousCategorieDTO sousCategorieDTO)
    {
        return  sousCategorieService.updateSousCategorie(sousCategorieDTO);
    }
    
    
    @ApiOperation(value = "getAllSousCategories")
    @GetMapping("/SousCategories")
    public List<SousCategorieDTO> getAllSousCategories()
    {
        return  sousCategorieService.getAllSousCategories();
       
    }

    
}