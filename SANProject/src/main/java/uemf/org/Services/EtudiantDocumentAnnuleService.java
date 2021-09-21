package uemf.org.Services;

import java.util.List;

import uemf.org.Models.EtudiantDocumentAnnuleDTO;

public interface EtudiantDocumentAnnuleService {


	 List<EtudiantDocumentAnnuleDTO> getEtudiantDocumentAnnulesCriteria(String anneScolaire, String typeDocument
			 ,Long matriculeEtudiant, String nomEtudiant);

	 
	 
}
