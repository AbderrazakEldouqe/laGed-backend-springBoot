package uemf.org.Services;

import java.util.List;

import uemf.org.Models.EtudiantDTO;

public interface EtudiantService {

     Long getCountAllEtudiants();
     
     List<EtudiantDTO> getAllEtudiantByAnneScolaires(String anneeScolaire);

	

}
