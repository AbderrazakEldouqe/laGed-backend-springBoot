package uemf.org.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import uemf.org.Entities.ErrorEntity;

public interface ErrorRepository extends JpaRepository<ErrorEntity, Integer>{
    
	ErrorEntity findByCodeError(int codeError);
}
