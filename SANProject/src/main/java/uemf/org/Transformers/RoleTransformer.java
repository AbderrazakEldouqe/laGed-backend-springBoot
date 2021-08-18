package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import uemf.org.Entities.RoleEntity;
import uemf.org.Models.RoleDTO;

@Component
public class RoleTransformer {

	
	public RoleDTO entityToDTO(RoleEntity roleEntity) {
		if(roleEntity==null) return null;
		RoleDTO roleDTO = new RoleDTO();
		BeanUtils.copyProperties(roleEntity,roleDTO);
		return roleDTO;
	}
	
	
	public RoleEntity DTOToEntity(RoleDTO roleDTO) {
		if(roleDTO==null) return null;
		RoleEntity roleEntity = new RoleEntity();
		BeanUtils.copyProperties(roleDTO,roleEntity);
		return roleEntity;
		}
	
}
