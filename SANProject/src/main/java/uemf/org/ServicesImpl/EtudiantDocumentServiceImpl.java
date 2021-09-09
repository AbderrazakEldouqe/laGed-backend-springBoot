package uemf.org.ServicesImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.EtudiantDocumentDTO;
import uemf.org.Repositories.EtudiantDocumentRepository;
import uemf.org.Services.EtudiantDocumentService;
import uemf.org.Transformers.EtudiantDocumentTransformer;

@Service
@Slf4j
public class EtudiantDocumentServiceImpl implements EtudiantDocumentService{
	
	@Autowired
	EtudiantDocumentRepository etudiantDocumentRepository;
	
	@Autowired
	EtudiantDocumentTransformer etudiantDocumentTransformer;
	
	@Override
	public List<String> getAllAnneScolaires() {
		return etudiantDocumentRepository.findAnneeScolaire();
	}

	 public List<EtudiantDocumentDTO> getEtudiantDocumentCriteria(String anneScolaire, String typeDocument
				 ,Long matriculeEtudiant, String nomEtudiant){
		 return etudiantDocumentRepository.getEtudiantDocumentCriteria(anneScolaire, typeDocument, matriculeEtudiant, nomEtudiant)
				 .stream().map(etudiantDocumentTransformer::entityToDTO).collect(Collectors.toList());
	 }
	
	public EtudiantDocumentDTO getDocumentById (Long idDocument) {
		return etudiantDocumentTransformer.entityToDTO(etudiantDocumentRepository.getById(idDocument));
	}
		
	 public ResponseEntity<Resource> downloadFile(Long idDocument) throws IOException {
		 EtudiantDocumentDTO documentDTO = getDocumentById(idDocument);
	        Path path = Paths.get(documentDTO.getCheminDoc());
	        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
	        HttpHeaders header = new HttpHeaders();
	        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentDTO.getNomDoc() + "\"");
	        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        header.add("Pragma", "no-cache");
	        header.add("Expires", "0");
	        return ResponseEntity.ok().headers(header)
	                .contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
	    }

	public Long getCountAllDocuments() {
			return etudiantDocumentRepository.count();
	}

	
	
	
	
	


}
