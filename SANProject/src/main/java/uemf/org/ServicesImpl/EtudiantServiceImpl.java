package uemf.org.ServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Entities.EtudiantEntity;
import uemf.org.Exceptions.BadRequestException;
import uemf.org.Models.CustomUserDetailsDTO;
import uemf.org.Models.EtudiantDTO;
import uemf.org.Models.EtudiantDocumentDTO;
import uemf.org.Models.UserDTO;
import uemf.org.Repositories.EtudiantDocumentRepository;
import uemf.org.Repositories.EtudiantRepository;
import uemf.org.Services.EtudiantService;
import uemf.org.Services.UserService;
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
	
	@Autowired
	UserService userService;
	
	@Override
	public Long getCountAllEtudiants() {
		
		return etudiantRepository.count();
	}


	@Override
	public List<EtudiantDTO> getAllEtudiantByAnneScolaires(String anneeScolaire) {
				
		try {    
			log.info("DEBUT DE LA METHODE getAllEtudiantByAnneScolaires :{}", anneeScolaire);
			return etudiantRepository.findAllEtudiantByAnneeScolaire(anneeScolaire)
					.stream().map(etudiantTransformer::entityToDTO).collect(Collectors.toList());
			
		} catch (Exception e) {
			log.error("ERROR HORS DE LA METHODE getAllEtudiantByAnneScolaires :{}", e.getMessage());
			throw new BadRequestException(e.getMessage());
		}
		
		
	 }





}
