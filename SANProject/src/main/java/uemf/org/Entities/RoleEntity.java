package uemf.org.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="role")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class RoleEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_role")
	private Long idRole;
	
	@Column(name= "role")
	private String roleName;
	
	




}
