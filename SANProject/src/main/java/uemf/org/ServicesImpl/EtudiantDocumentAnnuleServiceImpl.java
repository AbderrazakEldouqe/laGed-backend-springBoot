package uemf.org.ServicesImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Entities.EtudiantDocumentAnnuleEntity;
import uemf.org.Entities.EtudiantDocumentEntity;
import uemf.org.Exceptions.BadRequestException;
import uemf.org.Models.EtudiantDocumentAnnuleDTO;
import uemf.org.Repositories.EtudiantDocumentAnnuleRepository;
import uemf.org.Repositories.EtudiantDocumentRepository;
import uemf.org.Services.EtudiantDocumentAnnuleService;
import uemf.org.Transformers.EtudiantDocumentAnnuleTransformer;
import uemf.org.Transformers.EtudiantDocumentTransformer;

@Service
@Slf4j
public class EtudiantDocumentAnnuleServiceImpl implements EtudiantDocumentAnnuleService {
	
	
	@Autowired
	EtudiantDocumentAnnuleRepository etudiantDocumentAnnuleRepository;
	
	

	@Autowired
	EtudiantDocumentRepository etudiantDocumentRepository;
	
	@Autowired
	EtudiantDocumentAnnuleTransformer etudiantDocumentAnnuleTransformer;
	
	
	@Override
	public List<EtudiantDocumentAnnuleDTO> getEtudiantDocumentAnnulesCriteria(String anneScolaire, String typeDocument,
			Long matriculeEtudiant, String nomEtudiant) {
		
		 List<String> allCriteres= new ArrayList<String>();
		 if(anneScolaire != null) allCriteres.add(anneScolaire);
		 if(typeDocument != null) allCriteres.add(typeDocument);
		 if(matriculeEtudiant != null) allCriteres.add(matriculeEtudiant.toString());
		 if(nomEtudiant != null) allCriteres.add(nomEtudiant);

		 
	   try {
		   log.info("DEBUT DE LA METHODE getEtudiantDocumentAnnulesCriteria ");
		   
		   for (String critere : allCriteres)
		   {
			   log.info("Search avec :{} ", critere);
		   }
		   
		   return etudiantDocumentAnnuleRepository.getEtudiantDocumentAnnulesCriteria(anneScolaire, typeDocument, matriculeEtudiant, nomEtudiant)
		                   .stream().map(etudiantDocumentAnnuleTransformer::entityToDTO).collect(Collectors.toList());
			
		} catch (Exception e) {
			log.error("ERROR HORS DE LA METHODE getAllAnneScolaires :{}", e.getMessage());
			throw new BadRequestException(e.getMessage());
		}
	   
	}


	@Override
	public EtudiantDocumentAnnuleDTO saveDocumentAnnule(Long idDoc, String motif) {
		
		   log.info("DEBUT DE LA METHODE  saveDocumentAnnule");

		EtudiantDocumentEntity etudiantDocumentEntity= null;
		 EtudiantDocumentAnnuleEntity etudiantDocumentAnnule = new EtudiantDocumentAnnuleEntity();

		
	 try {
		    log.info("SEARCH WITH ID", idDoc);  
			 etudiantDocumentEntity = etudiantDocumentRepository.findById(idDoc).get();
			 etudiantDocumentAnnule.setMotif(motif);
			 etudiantDocumentAnnule.setDateAnnulation(new Date());
			//etudiantDocumentAnnule.getAnnulePar();
			 etudiantDocumentAnnule.setEtudiantDocumentEntity(etudiantDocumentEntity);
			 etudiantDocumentAnnule.getEtudiantDocumentEntity().setAnnule(true);
			 etudiantDocumentAnnuleRepository.save(etudiantDocumentAnnule);

			 log.info("Save with Succes etudiantDocumentAnnule ID{} ", idDoc);


		} catch (Exception e) {
			
			log.error("ERROR HORS DE LA METHODE saveDocumentAnnule :{}", e.getMessage());
			throw new BadRequestException(e.getMessage());
		}
		
		return etudiantDocumentAnnuleTransformer.entityToDTO(etudiantDocumentAnnule);

	}
	
	




}
