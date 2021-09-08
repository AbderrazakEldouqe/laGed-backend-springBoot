package uemf.org.Entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class EtudiantDocumentPK implements Serializable{
	
	private Long etudiantEntity;
	private Long documentEntity;
	private String anneeScolaire;

}
