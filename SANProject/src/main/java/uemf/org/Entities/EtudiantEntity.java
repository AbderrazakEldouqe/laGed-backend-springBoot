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

@Table(name="etudiants")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class EtudiantEntity {

	@Id
	@Column(name= "matricule_etud")
	private Long idEtudiant;
	
	@Column(name= "nom")
	private String nom;
	
	@Column(name= "prenom")
	private String prenom;
	
	@Column(name= "email")
	private String email;
	




}
