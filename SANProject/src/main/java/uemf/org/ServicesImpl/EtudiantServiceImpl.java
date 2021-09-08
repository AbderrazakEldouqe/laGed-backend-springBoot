package uemf.org.ServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Entities.EtudiantEntity;
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
		
		List<EtudiantDTO>  etudiants = new ArrayList<>();
		
		List<EtudiantDocumentDTO>  EtudiantDocuments = etudiantDocumentRepository.findAllByAnneeScolaire(anneeScolaire)
				          .stream().map(etudiantDocumentTransformer::entityToDTO)
				          .collect(Collectors.toList());
		
		for (EtudiantDocumentDTO etudiantDocument: EtudiantDocuments)
		{
			etudiants.add(etudiantDocument.getEtudiantDTO());
		}
		
		return etudiants;
		
	 }





}
