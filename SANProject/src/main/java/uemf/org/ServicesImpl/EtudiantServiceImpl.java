package uemf.org.ServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Entities.EtudiantEntity;
import uemf.org.Exceptions.BadRequestException;
import uemf.org.Models.EtudiantDTO;
import uemf.org.Models.EtudiantDocumentDTO;
import uemf.org.Repositories.EtudiantDocumentRepository;
import uemf.org.Repositories.EtudiantRepository;
import uemf.org.Services.EtudiantService;
import uemf.org.Transformers.EtudiantDocumentTransformer;
import uemf.org.Transformers.EtudiantTransformer;

@Service
@Slf4j
public class EtudiantServiceImpl implements EtudiantService{
	
	

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	EtudiantDocumentRepository etudiantDocumentRepository;
	
	@Autowired
	EtudiantDocumentTransformer etudiantDocumentTransformer;
	
	@Autowired
	EtudiantTransformer etudiantTransformer;
	
	@Override
	public Long getCountAllEtudiants() {
		
		return etudiantRepository.count();
	}


	@Override
	public List<EtudiantDTO> getAllEtudiantByAnneScolaires(String anneeScolaire) {
				
		try {    
			return etudiantRepository.findAllEtudiantByAnneeScolaire(anneeScolaire)
					.stream().map(etudiantTransformer::entityToDTO).collect(Collectors.toList());
			
		} catch (Exception e) {
			throw new BadRequestException(e.getMessage());
		}
		
		
	 }





}
