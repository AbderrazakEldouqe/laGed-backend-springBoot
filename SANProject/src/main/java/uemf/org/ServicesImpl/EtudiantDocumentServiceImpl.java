package uemf.org.ServicesImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisNoOpBindingRegistry;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Exceptions.BadRequestException;
import uemf.org.Exceptions.ConflitException;
import uemf.org.Exceptions.NotFoundException;
import uemf.org.Models.CustomUserDetailsDTO;
import uemf.org.Models.EtudiantDocumentDTO;
import uemf.org.Repositories.EtudiantDocumentRepository;
import uemf.org.Requests.FileRequest;
import uemf.org.Requests.UploadFilesRequest;
import uemf.org.Services.EtudiantDocumentAnnuleService;
import uemf.org.Services.EtudiantDocumentService;
import uemf.org.Services.UserService;
import uemf.org.Transformers.EtudiantDocumentTransformer;


@Service
@Slf4j
public class EtudiantDocumentServiceImpl implements EtudiantDocumentService{
	
	@Autowired
	EtudiantDocumentRepository etudiantDocumentRepository;
	
	
	@Autowired
	EtudiantDocumentAnnuleService etudiantDocumentAnnuleService;
	
	
	@Autowired
	EtudiantDocumentTransformer etudiantDocumentTransformer;
	
	
	@Autowired
	UserService userService;
	
	@Autowired
    Environment env;
	
	
	@Override
	public List<String> getAllAnneScolaires() {
		return etudiantDocumentRepository.findAnneeScolaire();
	}

	 public List getEtudiantDocumentCriteria(String anneScolaire, String typeDocument
				 ,Long matriculeEtudiant, String nomEtudiant , boolean isDocumentAnnule)
	 {
		 
		 List<String> allCriteres= new ArrayList<String>();
		 if(anneScolaire != null) allCriteres.add(anneScolaire);
		 if(typeDocument != null) allCriteres.add(typeDocument);
		 if(matriculeEtudiant != null) allCriteres.add(matriculeEtudiant.toString());
		 if(nomEtudiant != null) allCriteres.add(nomEtudiant);

		 
	   try {
		   log.info("DEBUT DE LA METHODE getEtudiantDocumentCriteria ");
		   
		   for (String critere : allCriteres)
		   {
			   log.info("Search avec :{} ", critere);
		   }
		   
		   if(isDocumentAnnule)
		   {
			   return etudiantDocumentAnnuleService.getEtudiantDocumentAnnulesCriteria(anneScolaire, typeDocument, matriculeEtudiant, nomEtudiant);
		  
		   }
		  else 
		   {
			return etudiantDocumentRepository.getEtudiantDocumentCriteria(anneScolaire, typeDocument, matriculeEtudiant, nomEtudiant)
					 .stream().map(etudiantDocumentTransformer::entityToDTO).collect(Collectors.toList());
			
	        }
			
			
			
			
		} catch (Exception e) {
			log.error("ERROR HORS DE LA METHODE getEtudiantDocumentCriteria :{}", e.getMessage());
			throw new BadRequestException(e.getMessage());
		}
		 
	 }
	
	public EtudiantDocumentDTO getDocumentById (Long idDocument) {
		try {
			 log.info("DEBUT DE LA METHODE getDocumentById avec :{} ", idDocument);
			return etudiantDocumentTransformer.entityToDTO(etudiantDocumentRepository.getById(idDocument));
		} catch (Exception e) {
			log.error("ERROR HORS DE LA METHODE getDocumentById :{}", e.getMessage());
			throw new BadRequestException(e.getMessage());
		}
	}
		
	 public ResponseEntity<Resource> downloadFile(Long idDocument) {
		 EtudiantDocumentDTO documentDTO = getDocumentById(idDocument);
	        Path path = Paths.get(documentDTO.getCheminDoc());
	        ByteArrayResource resource;
			try {
				log.info("DEBUT DE LA METHODE downloadFile avec :{} ", idDocument);
				resource = new ByteArrayResource(Files.readAllBytes(path));
				HttpHeaders header = new HttpHeaders();
		        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentDTO.getNomDoc() + "\"");
		        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		        header.add("Pragma", "no-cache");
		        header.add("Expires", "0");
		        return ResponseEntity.ok().headers(header)
		                .contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
			} catch (IOException e) {
				log.error("ERROR HORS DE LA METHODE downloadFile :{}", e.getMessage());
				 throw new BadRequestException(e.getMessage());
			}
	        
	    }

	public Long getCountAllDocuments()
    {
			try {
				log.info("DEBUT DE LA METHODE getCountAllDocuments");
				return etudiantDocumentRepository.count();
			} catch (Exception e) {
				log.error("ERROR HORS DE LA METHODE getCountAllDocuments :{}", e.getMessage());
				 throw new BadRequestException(e.getMessage());
			}
	}

	public void uploadListFile(UploadFilesRequest uploadFilesRequest) {
		 
	  log.info("DEBUT DE LA METHODE uploadListFile");
	  String path = env.getProperty("url.server.UploadFiles");
	  
	    if(uploadFilesRequest == null) return;
	  
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
		
			      	CustomUserDetailsDTO auth = (CustomUserDetailsDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			      	etudiantDocumentDTO.setCreateur(userService.getUserById(auth.getIdUser()));
			      	
			        etudiantDocumentRepository.save(etudiantDocumentTransformer.DTOToEntity(etudiantDocumentDTO));
			        log.info("FIN DE LA METHODE uploadListFile");
			    } catch (IOException e) 
			     {
			    	 log.error("ERROR HORS DE LA METHODE uploadListFile : {}", e.getMessage());
			         throw new BadRequestException(e.getMessage());
			     }
			}
		}
	
	public List<EtudiantDocumentDTO> getEtudiantDocumentByLastAnneScolaire()
	{
		try {
			log.info("DEBUT DE LA METHODE getEtudiantDocumentByLastAnneScolaire");
			String lastAnneeScolaire =etudiantDocumentRepository.getLastAnneScolaire();
			  return etudiantDocumentRepository.getEtudiantDocumentCriteria(lastAnneeScolaire, null, null, null)
						 .stream().map(etudiantDocumentTransformer::entityToDTO).collect(Collectors.toList());
		   }catch (Exception e) {
			   log.error("ERROR HORS DE LA METHODE uploadListFile :{}",e.getMessage() );
			   throw new ConflitException("Erreur lors d execution du Service getEtudiantDocumentByLastAnneScolaire");
			} 
	  }

	
	@Override
	public EtudiantDocumentDTO updateFile(FileRequest fileRequest) {
  		
		if(fileRequest == null) return null;
		else {
			
			try {
				log.info("DEBUT DE LA METHODE updateFile");
				EtudiantDocumentDTO etudiantDocumentDTO = getDocumentById(fileRequest.getIdFile());
		      	etudiantDocumentDTO.setCategorieDTO(fileRequest.getCategorieDTO());
		      	etudiantDocumentDTO.setLibelleCompl(fileRequest.getLibelleComplementaire());
		      	etudiantDocumentDTO.setNomDoc(fileRequest.getFileName());
		      	etudiantDocumentDTO.setFileBase64(fileRequest.getFilebase64());
		        etudiantDocumentRepository.save(etudiantDocumentTransformer.DTOToEntity(etudiantDocumentDTO));
	 
			    return etudiantDocumentDTO;
				
			} catch (NotFoundException e) {
				log.error("ERROR HORS DE LA METHODE updateFile :{}",e.getMessage() );
				throw new NotFoundException( String.format("etudiantDocumentDTO introuvable avec l ID: ", fileRequest.getIdFile()));
			}
			catch (Exception e) {
				log.error("ERROR HORS DE LA METHODE updateFile :{}",e.getMessage() );
				throw new ConflitException( String.format("Impossible d enregistrer etudiantDocumentDTO avec l ID: ", fileRequest.getIdFile()));
			}
			
		}
		
	}
}
	
