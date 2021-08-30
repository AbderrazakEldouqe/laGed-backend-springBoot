package uemf.org.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Repositories.EtudiantRepository;
import uemf.org.Services.EtudiantService;

@Service
@Slf4j
public class EtudiantServiceImpl implements EtudiantService{
	
	

	@Autowired
	EtudiantRepository etudiantRepository;
	
	
	@Override
	public Long getCountAllEtudiants() {
		
		return etudiantRepository.count();
	}





}
