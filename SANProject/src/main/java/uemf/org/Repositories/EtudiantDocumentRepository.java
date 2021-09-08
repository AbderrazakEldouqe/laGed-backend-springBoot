package uemf.org.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uemf.org.Entities.EtudiantDocumentEntity;
import uemf.org.Entities.EtudiantEntity;

public interface EtudiantDocumentRepository extends JpaRepository<EtudiantDocumentEntity, Long> {

	  @Query(value="SELECT DISTINCT(annee_scolaire) from etudiants_documents",  nativeQuery = true)
	  List<String> findAnneeScolaire();
	  
	 List<EtudiantDocumentEntity> findAllByAnneeScolaire(String anneeScolaire);
	  
	  
	
}
