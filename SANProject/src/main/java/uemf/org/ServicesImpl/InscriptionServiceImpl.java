package uemf.org.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.EtudiantDTO;
import uemf.org.Repositories.InscriptionRepository;
import uemf.org.Services.InscriptionService;
import uemf.org.Transformers.EtudiantTransformer;

@Service
@Slf4j
public class InscriptionServiceImpl implements InscriptionService{
	
	@Autowired
	InscriptionService inscriptionService;
	
	@Autowired
	EtudiantTransformer etudiantTransformer;
	
	@Autowired
	InscriptionRepository inscriptionRepository;
	
	public List<EtudiantDTO> getAllEtudiantByAnneeScolaire(String annee) {
		return inscriptionRepository.findByAnnee(annee).
				stream().map(etudiantTransformer::entityToDTO).collect(Collectors.toList());
	}
	
	
	
	@Override
	public List<String> getAllAnneScolaires() {
		return inscriptionRepository.findAnneeScolaire();
	}

	
}
