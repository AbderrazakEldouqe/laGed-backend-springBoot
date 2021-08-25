package uemf.org.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Utilisateurs")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_utilisateur")
	private Long idUser;
	
	@Column(name= "login" ,nullable= false, unique=true)
	private String login;
	
	@Column(name= "password" ,nullable= false)
	private String passWord;
	
	@Column(name= "nom_complet")
	private String userFullNmae;
	
	
	@ManyToOne
	@JoinColumn( name="id_role" )
	private RoleEntity userRole;




}
