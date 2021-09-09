package uemf.org.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uemf.org.Models.CategorieDTO;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class FileRequest {
	private String filebase64;
	private String fileName;
	private String  libelleComplementaire;
	private CategorieDTO categorieDTO;
	
}
