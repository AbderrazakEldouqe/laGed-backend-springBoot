package uemf.org.Services;

import java.util.List;

import uemf.org.Models.EtudiantDTO;

public interface InscriptionService {
	
	public  List<EtudiantDTO> getAllEtudiantByAnneeScolaire(String annee);

	
	List<String> getAllAnneScolaires();
	
}
