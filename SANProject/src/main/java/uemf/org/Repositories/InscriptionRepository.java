package uemf.org.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uemf.org.Entities.EtudiantEntity;
import uemf.org.Entities.InscriptionEntity;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {
	
	List<EtudiantEntity> findByAnnee (String annee);
	
	
	 @Query(value="SELECT DISTINCT(annee) from inscriptions",  nativeQuery = true)
	  List<String> findAnneeScolaire();

}
