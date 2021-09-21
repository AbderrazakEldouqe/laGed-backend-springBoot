package uemf.org.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uemf.org.Models.CategorieDTO;
import uemf.org.Models.SousCategorieDTO;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class FileRequest {
	
	private Long idFile;
	private String filebase64;
	private String fileName;
	private String  libelleComplementaire;
	private SousCategorieDTO sousCategorieDTO;
	
}
