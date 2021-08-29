package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uemf.org.Entities.DocumentEntity;
import uemf.org.Models.DocumentDTO;

@Component
public class DocumentTransformer {
	@Autowired
	CategorieTransformer categorieTransformer;
	
	public DocumentDTO entityToDTO(DocumentEntity documentEntity) {
		if(documentEntity==null) return null;
		DocumentDTO documentDTO = new DocumentDTO();
		BeanUtils.copyProperties(documentEntity,documentDTO);
		documentDTO.setCategorieDTO(categorieTransformer.entityToDTO(documentEntity.getCategorieEntity()));
		return documentDTO;
	}
	
	
	public DocumentEntity DTOToEntity(DocumentDTO documentDTO) {
		if(documentDTO==null) return null;
		DocumentEntity documentEntity = new DocumentEntity();
		BeanUtils.copyProperties(documentDTO,documentEntity);
		documentEntity.setCategorieEntity(categorieTransformer.DTOToEntity(documentDTO.getCategorieDTO()));
		return documentEntity;
		}
	
}
