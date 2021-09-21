package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uemf.org.Entities.EtudiantDocumentEntity;
import uemf.org.Models.EtudiantDocumentDTO;

@Component
public class EtudiantDocumentTransformer {
	
	@Autowired
	EtudiantTransformer etudiantTransformer;
	
	@Autowired
	SousCategorieTransformer sousCategorieTransformer;
	
	@Autowired
	UserTransformer userTransformer;
	
	
	public EtudiantDocumentDTO entityToDTO(EtudiantDocumentEntity etudiantDocumentEntity) {
		if(etudiantDocumentEntity==null) return null;
		EtudiantDocumentDTO etudiantDocumentDTO = new EtudiantDocumentDTO();
		BeanUtils.copyProperties(etudiantDocumentEntity,etudiantDocumentDTO);
		etudiantDocumentDTO.setEtudiantDTO(etudiantTransformer.entityToDTO(etudiantDocumentEntity.getEtudiantEntity()));
		etudiantDocumentDTO.setSousCategorieDTO(sousCategorieTransformer.entityToDTO(etudiantDocumentEntity.getSousCategorieEntity()));
		etudiantDocumentDTO.setCreateur(userTransformer.entityToDTO(etudiantDocumentEntity.getCreateur()));
		return etudiantDocumentDTO;
	}
	
	
	public EtudiantDocumentEntity DTOToEntity(EtudiantDocumentDTO etudiantDocumentDTO) {
		if(etudiantDocumentDTO==null) return null;
		EtudiantDocumentEntity etudiantDocumentEntity = new EtudiantDocumentEntity();
		BeanUtils.copyProperties(etudiantDocumentDTO,etudiantDocumentEntity);
		etudiantDocumentEntity.setEtudiantEntity(etudiantTransformer.DTOToEntity(etudiantDocumentDTO.getEtudiantDTO()));
		etudiantDocumentEntity.setSousCategorieEntity(sousCategorieTransformer.DTOToEntity(etudiantDocumentDTO.getSousCategorieDTO()));
		etudiantDocumentEntity.setCreateur(userTransformer.DTOToEntity(etudiantDocumentDTO.getCreateur()));
		return etudiantDocumentEntity;
		}
	
}
