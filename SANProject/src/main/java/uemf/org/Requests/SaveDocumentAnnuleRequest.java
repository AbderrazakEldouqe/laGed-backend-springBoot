package uemf.org.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class SaveDocumentAnnuleRequest {

	private Long idFile;
	private String motif;
}
