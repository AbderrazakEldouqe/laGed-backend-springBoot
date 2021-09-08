package uemf.org.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Entities.CategorieEntity;
import uemf.org.Models.CategorieDTO;
import uemf.org.Repositories.CategorieRepository;
import uemf.org.Services.CategorieService;
import uemf.org.Transformers.CategorieTransformer;

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
            CategorieEntity categorieEntity = categorieTransformer.DTOToEntity(categorieDTO);
            return categorieTransformer.entityToDTO(categorieRepository.save(categorieEntity));
        }
    }

    @Override
    public void deleteCategorie(Long idcategorieDTO) {
    
        categorieRepository.deleteById(idcategorieDTO);
    }

    @Override
    public List<CategorieDTO> getAllCategories() 
    {
        
         return categorieRepository.findAll()
                 .stream().map(categorieTransformer::entityToDTO).collect(Collectors.toList());
     }

    @Override
    public CategorieDTO getCategorieById(Long idcategorieDTO) {
        
        return categorieTransformer.entityToDTO(categorieRepository.findById(idcategorieDTO).get());
    }
    
    
	




}
