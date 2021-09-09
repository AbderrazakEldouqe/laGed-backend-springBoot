package uemf.org.ServicesImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.EtudiantDocumentDTO;
import uemf.org.Repositories.EtudiantDocumentRepository;
import uemf.org.Requests.FileRequest;
import uemf.org.Requests.UploadFilesRequest;
import uemf.org.Services.EtudiantDocumentService;
import uemf.org.Transformers.EtudiantDocumentTransformer;

@Service
@Slf4j
public class EtudiantDocumentServiceImpl implements EtudiantDocumentService{
	
	@Autowired
	EtudiantDocumentRepository etudiantDocumentRepository;
	
	@Autowired
	EtudiantDocumentTransformer etudiantDocumentTransformer;
	
	@Autowired
    Environment env;
	
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

	public void uploadListFile(UploadFilesRequest uploadFilesRequest) {
		  
	  String path = env.getProperty("url.server.UploadFiles");
	  
	  
		for (FileRequest fileRequest : uploadFilesRequest.getListFileRequest()) {
			
			EtudiantDocumentDTO etudiantDocumentDTO = new EtudiantDocumentDTO();
			
			    byte[] byteValueBase64Decoded = javax.xml.bind.DatatypeConverter
			            .parseBase64Binary(fileRequest.getFilebase64().split(",")[1]);
			    try {
			        FileUtils.writeByteArrayToFile(new File(path +fileRequest.getFileName()), byteValueBase64Decoded);
			        
			        etudiantDocumentDTO.setEtudiantDTO(uploadFilesRequest.getEtudiantDTO());
			        
			        etudiantDocumentDTO.setAnneeScolaire(uploadFilesRequest.getAnneeScolaire());
			     
			      	etudiantDocumentDTO.setCheminDoc(path + fileRequest.getFileName());
			      	
			      	etudiantDocumentDTO.setCategorieDTO(fileRequest.getCategorieDTO());
			      	
			      	etudiantDocumentDTO.setLibelleCompl(fileRequest.getLibelleComplementaire());
			      	
			      	etudiantDocumentDTO.setNomDoc(fileRequest.getFileName());
			      	
			      	etudiantDocumentDTO.setFileBase64(fileRequest.getFilebase64());
			      	
			      	etudiantDocumentDTO.setDateCreation(new Date());
			      	
			        etudiantDocumentRepository.save(etudiantDocumentTransformer.DTOToEntity(etudiantDocumentDTO));
			        
			    } catch (IOException e) {
			        System.out.println(e.getMessage());

			    }
			}
		}
	
	public List<EtudiantDocumentDTO> getEtudiantDocumentByLastAnneScolaire(){
		  String lastAnneeScolaire =etudiantDocumentRepository.getLastAnneScolaire();
		  return etudiantDocumentRepository.getEtudiantDocumentCriteria(lastAnneeScolaire, null, null, null)
					 .stream().map(etudiantDocumentTransformer::entityToDTO).collect(Collectors.toList());
	  }

	@Override
	public EtudiantDocumentDTO upDateFile(FileRequest fileRequest) {
  		
		EtudiantDocumentDTO etudiantDocumentDTO = getDocumentById(fileRequest.getIdFile());

	      	etudiantDocumentDTO.setCategorieDTO(fileRequest.getCategorieDTO());
	      	
	      	etudiantDocumentDTO.setLibelleCompl(fileRequest.getLibelleComplementaire());
	      	
	      	etudiantDocumentDTO.setNomDoc(fileRequest.getFileName());
	      	
	      	etudiantDocumentDTO.setFileBase64(fileRequest.getFilebase64());
	      	
	        etudiantDocumentRepository.save(etudiantDocumentTransformer.DTOToEntity(etudiantDocumentDTO));

		
		return etudiantDocumentDTO;
	}
		   
	 }
	
