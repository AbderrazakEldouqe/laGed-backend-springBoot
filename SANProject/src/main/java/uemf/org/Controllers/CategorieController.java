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
import uemf.org.Services.CategorieService;

 

@CrossOrigin("*")
@Api(value = "CategorieController", tags = { "Categorie Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Categorie Controller") })

 

@RestController
@RequestMapping("/apiCategorie")
public class CategorieController {
    
    
    @Autowired
    CategorieService categorieService;
    
    @ApiOperation(value = "saveCategorie")
    @PostMapping("/Categories")
    public CategorieDTO saveCategorie(@RequestBody CategorieDTO categorieDTO)
    {
        return  categorieService.saveCategorie(categorieDTO);
       
    }
     
    @ApiOperation(value = "deleteCategorie")
    @DeleteMapping("/Categories/{idCategorie}")
    public void deleteCategorie(@PathVariable("idCategorie") Long idCategorie)
    {
          categorieService.deleteCategorie(idCategorie);
    }
    
    
    @ApiOperation(value = "getCategorieById")
    @GetMapping("/Categories/{idCategorie}")
    public CategorieDTO getCategorieById(@PathVariable("idCategorie") Long idCategorie)
    {
        return  categorieService.getCategorieById(idCategorie);
          
    }

    
    @ApiOperation(value = "Categories")
    @PutMapping("/Categories/{idCategorie}")
    public CategorieDTO updateCategorie(@RequestBody CategorieDTO categorie)
    {
        return  categorieService.updateCategorie(categorie);
    }
    
    
    @ApiOperation(value = "getAllCategories")
    @GetMapping("/Categories")
    public List<CategorieDTO> getAllCategories()
    {
        return  categorieService.getAllCategories();
       
    }

    
}