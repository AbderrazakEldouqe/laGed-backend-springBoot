package uemf.org.Repositories;

import java.util.List;

import uemf.org.Entities.EtudiantDocumentEntity;

public interface EtudiantDocumentRepositoryCustom {
	
	 List<EtudiantDocumentEntity> getEtudiantDocumentCriteria(String anneScolaire, String typeDocument
			 ,Long matriculeEtudiant, String nomEtudiant);

}
