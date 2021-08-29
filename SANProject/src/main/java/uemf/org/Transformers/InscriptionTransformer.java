package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uemf.org.Entities.InscriptionEntity;
import uemf.org.Models.InscriptionDTO;

@Component
public class InscriptionTransformer {
	
	@Autowired
	EtudiantTransformer etudiantTransformer;
	
	public InscriptionDTO entityToDTO(InscriptionEntity inscriptionEntity) {
		if(inscriptionEntity==null) return null;
		InscriptionDTO inscriptionDTO = new InscriptionDTO();
		BeanUtils.copyProperties(inscriptionEntity,inscriptionDTO);
		inscriptionDTO.setEtudiantDTO(etudiantTransformer.entityToDTO(inscriptionEntity.getEtudiantEntity()));
		return inscriptionDTO;
	}
	
	
	public InscriptionEntity DTOToEntity(InscriptionDTO inscriptionDTO) {
		if(inscriptionDTO==null) return null;
		InscriptionEntity inscriptionEntity = new InscriptionEntity();
		BeanUtils.copyProperties(inscriptionDTO,inscriptionEntity);
		inscriptionEntity.setEtudiantEntity(etudiantTransformer.DTOToEntity(inscriptionDTO.getEtudiantDTO()));
		return inscriptionEntity;
		}
	
}
