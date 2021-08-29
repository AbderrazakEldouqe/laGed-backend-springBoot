package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import uemf.org.Entities.EtudiantEntity;
import uemf.org.Models.EtudiantDTO;

@Component
public class EtudiantTransformer {
	
	public EtudiantDTO entityToDTO(EtudiantEntity etudiantEntity) {
		if(etudiantEntity==null) return null;
		EtudiantDTO etudiantDTO = new EtudiantDTO();
		BeanUtils.copyProperties(etudiantEntity,etudiantDTO);
		return etudiantDTO;
	}
	
	
	public EtudiantEntity DTOToEntity(EtudiantDTO etudiantDTO) {
		if(etudiantDTO==null) return null;
		EtudiantEntity etudiantEntity = new EtudiantEntity();
		BeanUtils.copyProperties(etudiantDTO,etudiantEntity);
		return etudiantEntity;
		}
	
}
