package uemf.org.SAN.Transformers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import uemf.org.SAN.Entities.UserEntity;
import uemf.org.SAN.Models.UserDTO;

@Component
public class UserTransformer {

	
	public UserDTO entityToDTO(UserEntity userEntity) {
		if(userEntity==null) return null;
		UserDTO userDTO = new UserDTO();
		
		BeanUtils.copyProperties(userEntity,userDTO);
		return userDTO;
	}
	
	
	public UserEntity DTOToEntity(UserDTO userDTO) {
		if(userDTO==null) return null;
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDTO,userEntity);
		return userEntity;
		}
	
}
