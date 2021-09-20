package uemf.org.Models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class SousCategorieDTO implements Serializable {

	private Long idSousCategorie;
	private String libelle;
	private String description;
}
