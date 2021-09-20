package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uemf.org.Entities.CategorieEntity;
import uemf.org.Models.CategorieDTO;

@Component
public class CategorieTransformer {
	
	@Autowired
	SousCategorieTransformer sousCategorieTransformer;
	
	public CategorieDTO entityToDTO(CategorieEntity categorieEntity) {
		if(categorieEntity==null) return null;
		CategorieDTO categorieDTO = new CategorieDTO();
		BeanUtils.copyProperties(categorieEntity,categorieDTO);
		categorieDTO.setSousCategorieDTO(sousCategorieTransformer.entityToDTO(categorieEntity.getSousCategorieEntity()));
		return categorieDTO;
	}
	
	
	public CategorieEntity DTOToEntity(CategorieDTO categorieDTO) {
		if(categorieDTO==null) return null;
		CategorieEntity categorieEntity = new CategorieEntity();
		BeanUtils.copyProperties(categorieDTO,categorieEntity);
		categorieEntity.setSousCategorieEntity(sousCategorieTransformer.DTOToEntity(categorieDTO.getSousCategorieDTO()));
		return categorieEntity;
		}
	
}
