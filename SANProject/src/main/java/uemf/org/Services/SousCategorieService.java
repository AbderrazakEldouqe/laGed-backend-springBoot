package uemf.org.Services;

import java.util.List;

import uemf.org.Models.SousCategorieDTO;

public interface SousCategorieService {

	
   SousCategorieDTO saveSousCategorie(SousCategorieDTO sousCategorieDTO);
    
    void deleteSousCategorie(Long idsousCategorieDTO);
   
    SousCategorieDTO getSousCategorieById(Long idsousCategorieDTO);
   
    List<SousCategorieDTO>  getAllSousCategories();

    SousCategorieDTO updateSousCategorie(SousCategorieDTO sousCategorieDTO);
}
