package uemf.org.Models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class InscriptionDTO implements Serializable {

	private Long idInscription;
	private String annee;
	private EtudiantDTO etudiantDTO;
}
