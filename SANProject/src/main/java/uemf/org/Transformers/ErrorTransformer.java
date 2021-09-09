package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import uemf.org.Entities.ErrorEntity;
import uemf.org.Models.ErrorDTO;

@Component
public class ErrorTransformer {

	
	public ErrorDTO entityToDTO(ErrorEntity errorEntity) {
		if(errorEntity==null) return null;
		ErrorDTO errorDTO = new ErrorDTO();
		BeanUtils.copyProperties(errorEntity,errorDTO);
		return errorDTO;
	}
	
	
	public ErrorEntity DTOToEntity(ErrorDTO errorDTO) {
		if(errorDTO==null) return null;
		ErrorEntity errorEntity = new ErrorEntity();
		BeanUtils.copyProperties(errorDTO,errorEntity);
		return errorEntity;
		}
	
}
