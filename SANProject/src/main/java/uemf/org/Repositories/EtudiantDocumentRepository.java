package uemf.org.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uemf.org.Entities.EtudiantDocumentEntity;

public interface EtudiantDocumentRepository extends JpaRepository<EtudiantDocumentEntity, Long>,EtudiantDocumentRepositoryCustom {
	  
	// List<EtudiantDocumentEntity> findDistinctAllByAnneeScolaire(String anneeScolaire);
	  
	 List<EtudiantDocumentEntity> getEtudiantDocumentCriteria(String anneScolaire, String typeDocument
			 ,Long matriculeEtudiant, String nomEtudiant);
	 
	  @Query(value="select DISTINCT(annee_scolaire) from etudiants_documents ORDER BY annee_scolaire DESC LIMIT 1",  nativeQuery = true)
	  String getLastAnneScolaire();
	  
}
