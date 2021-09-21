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

@Table(name="categories")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class CategorieEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_categorie")
	private Long idCategorie;
	
	@Column(name= "libelle")
	private String libelle;
	
	@Column(name= "cat_doc")
	private String catDoc;
	
	
}
