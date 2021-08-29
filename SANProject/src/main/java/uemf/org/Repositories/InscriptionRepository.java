package uemf.org.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.Entities.EtudiantEntity;
import uemf.org.Entities.InscriptionEntity;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {
	
	List<EtudiantEntity> findByAnnee (String annee);

}
