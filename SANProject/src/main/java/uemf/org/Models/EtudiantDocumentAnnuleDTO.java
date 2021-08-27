package uemf.org.Models;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class EtudiantDocumentAnnuleDTO implements Serializable {

	private Long idEtudiantDocumentAnnule;
	private EtudiantDocumentAnnuleDTO etudiantDocumentAnnuleDTO;
	private Date dateAnnulation;
	private String motif;
	private String annulePar;
}
