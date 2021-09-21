package uemf.org.ServicesImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Entities.CategorieEntity;
import uemf.org.Entities.SousCategorieEntity;
import uemf.org.Exceptions.ConflitException;
import uemf.org.Exceptions.NotFoundException;
import uemf.org.Models.CategorieDTO;
import uemf.org.Models.SousCategorieDTO;
import uemf.org.Repositories.CategorieRepository;
import uemf.org.Repositories.SousCategorieRepository;
import uemf.org.Services.CategorieService;
import uemf.org.Services.SousCategorieService;
import uemf.org.Transformers.CategorieTransformer;
import uemf.org.Transformers.SousCategorieTransformer;

@Service
@Slf4j
public class SousCategorieServiceImpl  implements SousCategorieService{
	
	
	  @Autowired
	  SousCategorieRepository sousCategorieRepository;
	    
	  @Autowired
	  SousCategorieTransformer sousCategorieTransformer;
	
	
	@Override
	public SousCategorieDTO saveSousCategorie(SousCategorieDTO sousCategorieDTO) {
		
        if(sousCategorieDTO == null) return null;
        
        else 
        {
            try {
                log.info("DEBUT DE LA METHODE saveSousCategorie ");
                SousCategorieEntity sousCategorieEntity = sousCategorieTransformer.DTOToEntity(sousCategorieDTO);
                 return sousCategorieTransformer.entityToDTO(sousCategorieRepository.save(sousCategorieEntity));
                
            } catch (Exception e) 
            {
                log.error("Error lors de la methode saveSousCategorie : {}" ,e.getMessage()); 
                throw new ConflitException( String.format("Impossible d ajouter une nouvelle sousCategorieEntity "));

            }

        }
	}

	@Override
	public void deleteSousCategorie(Long idsousCategorieDTO) {

	       try {
	            log.info("DEBUT DE LA METHODE deleteSousCategorie ");
	            sousCategorieRepository.deleteById(idsousCategorieDTO);
	            log.info("delete SousCategorie avec succées ID : {} ", idsousCategorieDTO);
	            
	        } catch (Exception e) 
	        {
	            log.error("Error lord de la methode deleteSousCategorie : {}" ,e.getMessage()); 
	            throw new ConflitException( String.format("Impossible de supprimer Categorie avec l ID: ", idsousCategorieDTO));
	        
	        }
		
	}

	@Override
	public SousCategorieDTO getSousCategorieById(Long idsousCategorieDTO) {
		
	    
        try {
            log.info("DEBUT DE LA METHODE getSousCategorieById :{}",idsousCategorieDTO);
            return sousCategorieTransformer.entityToDTO(sousCategorieRepository.findById(idsousCategorieDTO).get());
         }
        
        catch (NoSuchElementException e ) {
             log.error("Error getCategorieById : {}" ,e.getMessage());
            throw new NotFoundException( String.format("SousCategorieById introuvable avec l ID: ", idsousCategorieDTO));
        }
	}

	@Override
	public List<SousCategorieDTO> getAllSousCategories() {
		
		 try {
	            log.info("DEBUT DE LA METHODE getAllSousCategories");
	            return sousCategorieRepository.findAll()
	                    .stream().map(sousCategorieTransformer::entityToDTO).collect(Collectors.toList());
	         } catch (Exception e) 
	         {
	             log.error("Error lors de la methode  getAllSousCategories : {}" ,e.getMessage()); 
	             throw new NotFoundException("La table getAllSousCategories est vide");
	         }
	}

	@Override
	public SousCategorieDTO updateSousCategorie(SousCategorieDTO sousCategorieDTO) {
		
		 if(sousCategorieDTO == null) return null;
	        else 
	        {
	            try {
	                log.info("DEBUT DE LA METHODE updateSousCategorie avec l ID: {} ", sousCategorieDTO.getIdSousCategorie() );
	                SousCategorieDTO sousCategorieTrouve= getSousCategorieById(sousCategorieDTO.getIdSousCategorie());
	                sousCategorieTrouve.setLibelle(sousCategorieDTO.getLibelle());
	                sousCategorieTrouve.setDescription(sousCategorieDTO.getDescription());
	                if(sousCategorieDTO.getCategorieDTO() != null)
	                  sousCategorieTrouve.setCategorieDTO(sousCategorieDTO.getCategorieDTO());
	                	
	                saveSousCategorie(sousCategorieTrouve);
	                return sousCategorieTrouve;
	                
	            } catch (NullPointerException e) {
	                 log.error("Error lors updateSousCategorie : {}" ,e.getMessage());
	                throw new NotFoundException( String.format("SousCategorie introuvable avec l ID: ", sousCategorieDTO.getIdSousCategorie()));
	            }
	            catch (ConflitException e) {
	                 log.error("Error updateSousCategorie : {}" ,e.getMessage());
	                throw new ConflitException( String.format("Impossible d enregistrer SousCategorie avec l ID: ", sousCategorieDTO.getIdSousCategorie()));
	            }
	            
	        }
	}

}
