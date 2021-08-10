package uemf.org.SAN.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.SAN.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
