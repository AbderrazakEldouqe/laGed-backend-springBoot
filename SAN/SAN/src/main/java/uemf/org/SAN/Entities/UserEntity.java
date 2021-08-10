package uemf.org.SAN.Entities;

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

@Table(name="Utilisateur")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	private Long idUser;
	
	@Column(name= "login")
	private String login;
	
	@Column(name= "password")
	private String passWord;
	
	@Column(name= "nom_complet")
	private String userFullNmae;
	
	@Column(name= "role")
	private String userRole;




}
