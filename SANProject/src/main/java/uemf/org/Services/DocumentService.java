package uemf.org.Services;

import uemf.org.Models.DocumentDTO;

public interface DocumentService {

	Long getCountAllDocuments();
	
	
	void uploadFile(Long idEtudiant, DocumentDTO  documentDTO);

	

}
