package uemf.org.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Repositories.DocumentRepository;
import uemf.org.Services.DocumentService;

@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	DocumentRepository documentRepository;
	
	
	@Override
	public Long getCountAllDocuments() {
		
		return documentRepository.count();
	}






}
