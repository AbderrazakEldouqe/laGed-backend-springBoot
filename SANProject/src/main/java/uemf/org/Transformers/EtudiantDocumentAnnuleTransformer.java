package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uemf.org.Entities.EtudiantDocumentAnnuleEntity;
import uemf.org.Models.EtudiantDocumentAnnuleDTO;

@Component
public class EtudiantDocumentAnnuleTransformer {
	
	@Autowired
	EtudiantDocumentTransformer etudiantDocumentTransformer;
	
	public EtudiantDocumentAnnuleDTO entityToDTO(EtudiantDocumentAnnuleEntity etudiantDocumentAnnuleEntity) {
		if(etudiantDocumentAnnuleEntity==null) return null;
		EtudiantDocumentAnnuleDTO etudiantDocumentAnnuleDTO = new EtudiantDocumentAnnuleDTO();
		BeanUtils.copyProperties(etudiantDocumentAnnuleEntity,etudiantDocumentAnnuleDTO);
		etudiantDocumentAnnuleDTO.setEtudiantDocumentDTO(etudiantDocumentTransformer.entityToDTO(etudiantDocumentAnnuleEntity.getEtudiantDocumentEntity()));
		return etudiantDocumentAnnuleDTO;
	}
	
	
	public EtudiantDocumentAnnuleEntity DTOToEntity(EtudiantDocumentAnnuleDTO etudiantDocumentAnnuleDTO) {
		if(etudiantDocumentAnnuleDTO==null) return null;
		EtudiantDocumentAnnuleEntity etudiantDocumentAnnuleEntity = new EtudiantDocumentAnnuleEntity();
		BeanUtils.copyProperties(etudiantDocumentAnnuleDTO,etudiantDocumentAnnuleEntity);
		etudiantDocumentAnnuleEntity.setEtudiantDocumentEntity(etudiantDocumentTransformer.DTOToEntity(etudiantDocumentAnnuleDTO.getEtudiantDocumentDTO()));
		return etudiantDocumentAnnuleEntity;
		}
	
}
