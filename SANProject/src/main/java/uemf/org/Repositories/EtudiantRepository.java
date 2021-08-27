package uemf.org.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.Entities.EtudiantEntity;

public interface EtudiantRepository extends JpaRepository<EtudiantEntity, Long> {

}
