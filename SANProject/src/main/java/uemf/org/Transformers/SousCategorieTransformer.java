package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uemf.org.Entities.SousCategorieEntity;
import uemf.org.Models.SousCategorieDTO;

@Component
public class SousCategorieTransformer {
	
	
	@Autowired
	CategorieTransformer categorieTransformer;
	
	public SousCategorieDTO entityToDTO(SousCategorieEntity sousCategorieEntity) {
		if(sousCategorieEntity==null) return null;
		SousCategorieDTO sousCategorieDTO = new SousCategorieDTO();
		BeanUtils.copyProperties(sousCategorieEntity,sousCategorieDTO);
		sousCategorieDTO.setCategorieDTO(categorieTransformer.entityToDTO(sousCategorieEntity.getCategorieEntity()));
		return sousCategorieDTO;
	}
	
	
	public SousCategorieEntity DTOToEntity(SousCategorieDTO sousCategorieDTO) {
		if(sousCategorieDTO==null) return null;
		SousCategorieEntity sousCategorieEntity = new SousCategorieEntity();
		BeanUtils.copyProperties(sousCategorieDTO,sousCategorieEntity);
		sousCategorieEntity.setCategorieEntity(categorieTransformer.DTOToEntity(sousCategorieDTO.getCategorieDTO()));
		return sousCategorieEntity;
		}

}
