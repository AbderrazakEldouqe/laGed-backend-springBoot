package uemf.org.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import uemf.org.Models.EtudiantDocumentDTO;
import uemf.org.Requests.UploadFilesRequest;

public interface EtudiantDocumentService {


    List<String> getAllAnneScolaires();
    
    EtudiantDocumentDTO getDocumentById (Long idDocument);
    
    ResponseEntity<Resource> downloadFile(Long idDocument) throws IOException; 
    
    Long getCountAllDocuments();
    
    List<EtudiantDocumentDTO> getEtudiantDocumentCriteria(String anneScolaire, String typeDocument
			 ,Long matriculeEtudiant, String nomEtudiant);
    

    void uploadListFile(UploadFilesRequest uploadFilesRequest);
    
    List<EtudiantDocumentDTO> getEtudiantDocumentByLastAnneScolaire(); 

}
