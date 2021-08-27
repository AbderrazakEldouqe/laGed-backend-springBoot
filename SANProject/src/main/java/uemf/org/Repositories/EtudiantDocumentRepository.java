package uemf.org.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.Entities.EtudiantDocumentEntity;

public interface EtudiantDocumentRepository extends JpaRepository<EtudiantDocumentEntity, Long> {

}
