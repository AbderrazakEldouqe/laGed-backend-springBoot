package uemf.org.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.Entities.DocumentEntity;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {

}
