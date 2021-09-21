package uemf.org.Models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class CategorieDTO implements Serializable {

	private Long idCategorie;
	private String libelle;
	private String catDoc;
}
