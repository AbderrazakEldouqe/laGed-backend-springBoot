package uemf.org.Requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uemf.org.Models.EtudiantDTO;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class UploadFilesRequest {
	private EtudiantDTO etudiantDTO;
	private String anneeScolaire;
	private List<FileRequest> listFileRequest;
	
}
