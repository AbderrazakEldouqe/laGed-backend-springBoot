package uemf.org.ServicesImpl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.DocumentDTO;
import uemf.org.Repositories.DocumentRepository;
import uemf.org.Services.DocumentService;
import uemf.org.Transformers.DocumentTransformer;
import uemf.org.Utils.Constant;
import org.apache.commons.io.FileUtils;


@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	Environment env;
	
	@Autowired
	DocumentRepository documentRepository;
	
	@Autowired
	DocumentTransformer documentTransformer;
	
	
	@Override
	public Long getCountAllDocuments() {
		
		return documentRepository.count();
	}


	@Override
	public void uploadFile(Long idEtudiant, DocumentDTO  documentDTO) {
		
    String path = env.getProperty(Constant.PATH_Document);
    byte[] byteValueBase64Decoded = javax.xml.bind.DatatypeConverter
            .parseBase64Binary(documentDTO.getByteContent().split(",")[1]);
    
    try {
        FileUtils.writeByteArrayToFile(new File(path + documentDTO.getIntitule()), byteValueBase64Decoded);
        documentRepository.save(documentTransformer.DTOToEntity(documentDTO));
    } catch (IOException e)
    {
      
    }
		
}






}
