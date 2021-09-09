package uemf.org.Services;

import java.util.List;

import uemf.org.Models.CategorieDTO;

public interface CategorieService {
	
	CategorieDTO saveCategorie(CategorieDTO categorieDTO);
    
    void deleteCategorie(Long idcategorieDTO);
   
    CategorieDTO getCategorieById(Long idcategorieDTO);
   
    List<CategorieDTO>  getAllCategories();

    CategorieDTO updateCategorie(CategorieDTO categorieDTO);
}
