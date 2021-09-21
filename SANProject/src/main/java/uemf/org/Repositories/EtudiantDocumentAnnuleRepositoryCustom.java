package uemf.org.Repositories;

import java.util.List;

import uemf.org.Entities.EtudiantDocumentAnnuleEntity;

public interface EtudiantDocumentAnnuleRepositoryCustom {
	
	 List<EtudiantDocumentAnnuleEntity> getEtudiantDocumentAnnulesCriteria(String anneScolaire, String typeDocument
			 ,Long matriculeEtudiant, String nomEtudiant);

}
