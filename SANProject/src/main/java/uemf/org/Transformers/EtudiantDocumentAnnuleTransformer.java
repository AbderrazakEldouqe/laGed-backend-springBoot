package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uemf.org.Entities.EtudiantDocumentAnnuleEntity;
import uemf.org.Models.EtudiantDocumentAnnuleDTO;
import uemf.org.Models.EtudiantDocumentDTO;

@Component
public class EtudiantDocumentAnnuleTransformer {
	
	@Autowired
    EtudiantDocumentTransformer etudiantDocumentTransformer;
   
    @Autowired
    EtudiantTransformer etudiantTransformer;
   
    @Autowired
    SousCategorieTransformer sousCategorieTransformer;
   
    @Autowired
    UserTransformer userTransformer;
	
	public EtudiantDocumentAnnuleDTO entityToDTO(EtudiantDocumentAnnuleEntity etudiantDocumentAnnuleEntity) {
		if(etudiantDocumentAnnuleEntity==null) return null;
		EtudiantDocumentAnnuleDTO etudiantDocumentAnnuleDTO = new EtudiantDocumentAnnuleDTO();
		BeanUtils.copyProperties(etudiantDocumentAnnuleEntity,etudiantDocumentAnnuleDTO);
		etudiantDocumentAnnuleDTO.setEtudiantDocumentDTO(etudiantDocumentTransformer.entityToDTO(etudiantDocumentAnnuleEntity.getEtudiantDocumentEntity()));
		return etudiantDocumentAnnuleDTO;
	}
	
	
	public EtudiantDocumentDTO entityToDTOEtudiantDocument(EtudiantDocumentAnnuleEntity etudiantDocumentAnnuleEntity) {
        if(etudiantDocumentAnnuleEntity==null) return null;
        EtudiantDocumentDTO etudiantDocumentDTO = new EtudiantDocumentDTO();
        BeanUtils.copyProperties(etudiantDocumentAnnuleEntity,etudiantDocumentDTO);
        BeanUtils.copyProperties(etudiantDocumentAnnuleEntity.getEtudiantDocumentEntity(),etudiantDocumentDTO);
        etudiantDocumentDTO.setEtudiantDTO(etudiantTransformer.entityToDTO(etudiantDocumentAnnuleEntity.getEtudiantDocumentEntity().getEtudiantEntity()));
        etudiantDocumentDTO.setSousCategorieDTO(sousCategorieTransformer.entityToDTO(etudiantDocumentAnnuleEntity.getEtudiantDocumentEntity().getSousCategorieEntity()));
        etudiantDocumentDTO.setCreateur(userTransformer.entityToDTO(etudiantDocumentAnnuleEntity.getEtudiantDocumentEntity().getCreateur()));
        return etudiantDocumentDTO;
    }
	
	
	
	public EtudiantDocumentAnnuleEntity DTOToEntity(EtudiantDocumentAnnuleDTO etudiantDocumentAnnuleDTO) {
		if(etudiantDocumentAnnuleDTO==null) return null;
		EtudiantDocumentAnnuleEntity etudiantDocumentAnnuleEntity = new EtudiantDocumentAnnuleEntity();
		BeanUtils.copyProperties(etudiantDocumentAnnuleDTO,etudiantDocumentAnnuleEntity);
		etudiantDocumentAnnuleEntity.setEtudiantDocumentEntity(etudiantDocumentTransformer.DTOToEntity(etudiantDocumentAnnuleDTO.getEtudiantDocumentDTO()));
		return etudiantDocumentAnnuleEntity;
	  }
    
	


}
