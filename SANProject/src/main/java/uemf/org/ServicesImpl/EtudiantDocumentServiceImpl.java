package uemf.org.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.EtudiantDTO;
import uemf.org.Repositories.EtudiantDocumentRepository;
import uemf.org.Services.EtudiantDocumentService;

@Service
@Slf4j
public class EtudiantDocumentServiceImpl implements EtudiantDocumentService{
	
	@Autowired
	EtudiantDocumentRepository etudiantDocumentRepository;
	
	@Override
	public List<String> getAllAnneScolaires() {
		return etudiantDocumentRepository.findAnneeScolaire();
	}

	



}
