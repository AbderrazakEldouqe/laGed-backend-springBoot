package uemf.org.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uemf.org.Entities.EtudiantEntity;

public interface EtudiantRepository extends JpaRepository<EtudiantEntity, Long> {
	
	

	
	@Query(value="select distinct e.* from etudiants e , inscriptions i where e.matricule_etud = i.id_etudiant and i.annee= ?",  nativeQuery = true)
	List<EtudiantEntity> findAllEtudiantByAnneeScolaire(@Param("anneeScolaire") String anneeScolaire);

}
