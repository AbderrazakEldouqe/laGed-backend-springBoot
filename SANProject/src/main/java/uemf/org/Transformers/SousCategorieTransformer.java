package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import uemf.org.Entities.SousCategorieEntity;
import uemf.org.Models.SousCategorieDTO;

@Component
public class SousCategorieTransformer {
	
	
	public SousCategorieDTO entityToDTO(SousCategorieEntity sousCategorieEntity) {
		if(sousCategorieEntity==null) return null;
		SousCategorieDTO sousCategorieDTO = new SousCategorieDTO();
		BeanUtils.copyProperties(sousCategorieEntity,sousCategorieDTO);
		return sousCategorieDTO;
	}
	
	
	public SousCategorieEntity DTOToEntity(SousCategorieDTO sousCategorieDTO) {
		if(sousCategorieDTO==null) return null;
		SousCategorieEntity sousCategorieEntity = new SousCategorieEntity();
		BeanUtils.copyProperties(sousCategorieDTO,sousCategorieEntity);
		return sousCategorieEntity;
		}

}
