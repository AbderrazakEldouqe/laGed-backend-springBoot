package uemf.org.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.Entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
