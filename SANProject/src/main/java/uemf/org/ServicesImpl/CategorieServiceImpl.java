package uemf.org.ServicesImpl;

 

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Entities.CategorieEntity;
import uemf.org.Exceptions.ConflitException;
import uemf.org.Exceptions.NotFoundException;
import uemf.org.Models.CategorieDTO;
import uemf.org.Repositories.CategorieRepository;
import uemf.org.Services.CategorieService;
import uemf.org.Transformers.CategorieTransformer;
import uemf.org.Transformers.SousCategorieTransformer;

 

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService{
    
    @Autowired
    CategorieRepository categorieRepository;
    
    @Autowired
    CategorieTransformer categorieTransformer;
    
	
    
    @Override
    public CategorieDTO saveCategorie(CategorieDTO categorieDTO) {
        
        if(categorieDTO == null) return null;
        
        else 
        {
            try {
                log.info("Début d'ajout d'une categorie");
                 CategorieEntity categorieEntity = categorieTransformer.DTOToEntity(categorieDTO);
                 return categorieTransformer.entityToDTO(categorieRepository.save(categorieEntity));
                
            } catch (Exception e) 
            {
                log.error("Error saveCategorie : {}" ,e.getMessage()); 
                throw new ConflitException( String.format("Impossible d ajouter une nouvelle Categorie "));

            }

        }
    }

 

    @Override
    public void deleteCategorie(Long idcategorieDTO) {
    
        try {
            log.info(" Début de suppression d'une Categorie.");
            categorieRepository.deleteById(idcategorieDTO);
            log.info("Categorie supprimer avec succées.");
            
        } catch (Exception e) 
        {
            log.error("Error deleteCategorie : {}" ,e.getMessage()); 
            throw new ConflitException( String.format("Impossible de supprimer Categorie avec l ID: ", idcategorieDTO));
        
        }
            
    
    }

 

    @Override
    public List<CategorieDTO> getAllCategories() 
    {
        try {
            log.info("Début de Recuperation de toutes  les Categories.");
            return categorieRepository.findAll()
                    .stream().map(categorieTransformer::entityToDTO).collect(Collectors.toList());
         } catch (Exception e) 
         {
             log.error("Error getAllCategories : {}" ,e.getMessage()); 
             throw new NotFoundException("La table Categories est vide");
         }
         
     }

 

    @Override
    public CategorieDTO getCategorieById(Long idcategorieDTO) {
        
        try {
            log.info("Début de Recuperation d'une Categorie par son Id :{}",idcategorieDTO);
            return categorieTransformer.entityToDTO(categorieRepository.findById(idcategorieDTO).get());
         }
        
        catch (NoSuchElementException e ) {
             log.error("Error getCategorieById : {}" ,e.getMessage());
            throw new NotFoundException( String.format("Categorie introuvable avec l ID: ", idcategorieDTO));
        }
        
    }

 

    @Override
    public CategorieDTO updateCategorie(CategorieDTO categorieDTO) {
        
        if(categorieDTO == null) return null;
        else 
        {
            try {
                log.info("Début de modification d'une Categorie.");
                CategorieDTO categorieTrouve= getCategorieById(categorieDTO.getIdCategorie());
                categorieTrouve.setCatDoc(categorieDTO.getCatDoc());
                categorieTrouve.setLibelle(categorieDTO.getLibelle());
                saveCategorie(categorieTrouve);
                return categorieTrouve;
                
            } catch (NotFoundException e) {
                 log.error("Error updateCategorie : {}" ,e.getMessage());
                throw new NotFoundException( String.format("Categorie introuvable avec l ID: ", categorieDTO.getIdCategorie()));
            }
            catch (ConflitException e) {
                 log.error("Error updateCategorie : {}" ,e.getMessage());
                throw new ConflitException( String.format("Impossible d enregistrer Categorie avec l ID: ", categorieDTO.getIdCategorie()));
            }
            
        }
        
    }
    
    
    

 

 


}