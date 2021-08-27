package uemf.org.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.Entities.InscriptionEntity;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {

}
