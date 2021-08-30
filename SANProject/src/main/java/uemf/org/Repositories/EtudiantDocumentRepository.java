package uemf.org.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uemf.org.Entities.EtudiantDocumentEntity;

public interface EtudiantDocumentRepository extends JpaRepository<EtudiantDocumentEntity, Long> {

	 @Query("SELECT DISTINCT(annee) from EtudiantDocumentEntity")
	 List<String> findDistinctAnnee();
	
}
