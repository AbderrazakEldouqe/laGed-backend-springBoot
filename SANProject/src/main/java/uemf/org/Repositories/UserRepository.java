package uemf.org.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import uemf.org.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByLoginAndPassWord(String login, String passWord);
	
	UserEntity findByLogin(String login);
}
