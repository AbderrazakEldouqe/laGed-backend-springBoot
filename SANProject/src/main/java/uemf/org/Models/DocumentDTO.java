package uemf.org.Models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class DocumentDTO implements Serializable {

	private Long idDocument;
	private String intitule;
	CategorieDTO categorieDTO;
}
