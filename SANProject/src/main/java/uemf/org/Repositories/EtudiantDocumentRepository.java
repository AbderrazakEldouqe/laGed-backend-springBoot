package uemf.org.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uemf.org.Entities.EtudiantDocumentEntity;

public interface EtudiantDocumentRepository extends JpaRepository<EtudiantDocumentEntity, Long>,EtudiantDocumentRepositoryCustom {

	  @Query(value="SELECT DISTINCT(annee_scolaire) from etudiants_documents",  nativeQuery = true)
	  List<String> findAnneeScolaire();
	  
	 List<EtudiantDocumentEntity> findAllByAnneeScolaire(String anneeScolaire);
	  
	 List<EtudiantDocumentEntity> getEtudiantDocumentCriteria(String anneScolaire, String typeDocument
			 ,Long matriculeEtudiant, String nomEtudiant);
	  
	
}
