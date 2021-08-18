package uemf.org.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uemf.org.Entities.UserEntity;
import uemf.org.Models.UserDTO;

@Component
public class UserTransformer {

	@Autowired
	RoleTransformer roleTransformer;
	
	public UserDTO entityToDTO(UserEntity userEntity) {
		if(userEntity==null) return null;
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userEntity,userDTO);
		userDTO.setUserRole(roleTransformer.entityToDTO(userEntity.getUserRole()));
		return userDTO;
	}
	
	
	public UserEntity DTOToEntity(UserDTO userDTO) {
		if(userDTO==null) return null;
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDTO,userEntity);
		userEntity.setUserRole(roleTransformer.DTOToEntity(userDTO.getUserRole()));
		return userEntity;
		}
	
}
