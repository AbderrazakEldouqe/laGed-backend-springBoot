package uemf.org.Entities;

import java.util.Date;

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

@Table(name="etudiants_documents")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class EtudiantDocumentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_etudiant_document")
	private Long idEtudiantDocument;
	
	@ManyToOne
	private EtudiantEntity etudiantEntity;
	
	@ManyToOne
	private DocumentEntity documentEntity;
	
	@Column(name= "libelle_compl")
	private String libelleCompl;
	
	@Column(name= "chemin_doc")
	private String cheminDoc;
	
	@Column(name= "annee")
	private String annee;
	
	@Column(name= "date_creation")
	private Date dateCreation;
	
	@Column(name= "createur")
	private String createur;
	
	




}
