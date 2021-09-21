package uemf.org.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="sous_categories")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class SousCategorieEntity {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_sous_categorie")
	private Long idSousCategorie;
	
	@Column(name= "libelle")
	private String libelle;
	
	@Column(name= "description")
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name="id__categorie")
	private CategorieEntity categorieEntity;

	

}
