package uemf.org.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.Entities.EtudiantDocumentAnnuleEntity;

public interface EtudiantDocumentAnnuleRepository extends JpaRepository<EtudiantDocumentAnnuleEntity, Long> , EtudiantDocumentAnnuleRepositoryCustom{

	
	
	
}
