package uemf.org.Models;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class EtudiantDocumentDTO implements Serializable {

	private Long idEtudiantDocument;
	private EtudiantDTO etudiantDTO;
	private DocumentDTO documentDTO;
	private String libelleCompl;
	private String cheminDoc;
	private String annee;
	private Date dateCreation;
	private String createur;
	
	
}
