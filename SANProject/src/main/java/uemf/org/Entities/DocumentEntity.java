package uemf.org.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="documents")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class DocumentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_document")
	private Long idDocument;
	
	@Column(name= "intitule")
	private String intitule;
	
	
	@ManyToOne
	private CategorieEntity categorieEntity;




}
