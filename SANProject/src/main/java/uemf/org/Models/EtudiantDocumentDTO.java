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

	private Long idDocument;
	private EtudiantDTO etudiantDTO;
	private CategorieDTO categorieDTO;
	private String libelleCompl;
	private String anneeScolaire;
	private String cheminDoc;
	private String nomDoc;
	private Date dateCreation;
	private String createur;

	
}
