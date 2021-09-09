package uemf.org.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.ErrorDTO;
import uemf.org.Repositories.ErrorRepository;
import uemf.org.Services.ErrorService;
import uemf.org.Transformers.ErrorTransformer;

@Service
@Slf4j
public class ErrorServiceImpl implements ErrorService{
	
	@Autowired
	ErrorRepository errorRepository;
	
	@Autowired
	ErrorTransformer errorTransformer;
	
	
	@Override
	public ErrorDTO getErrorByCodeError(int codeError) {
		
		return errorTransformer.entityToDTO(errorRepository.findByCodeError(codeError));
	}



}
