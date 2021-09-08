package uemf.org.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
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
@IdClass(EtudiantDocumentPK.class)
public class EtudiantDocumentEntity {

	@Id	
	@ManyToOne
	@JoinColumn(name="id_etudiant")
	private EtudiantEntity etudiantEntity;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_document")
	private DocumentEntity documentEntity;
	
	@Id	
	@Column(name= "annee_scolaire")
	private String anneeScolaire;
	
	@Column(name= "libelle_compl")
	private String libelleCompl;
	
	@Column(name= "chemin_doc")
	private String cheminDoc;
	
	
	@Column(name= "date_creation")
	private Date dateCreation;
	
	@Column(name= "createur")
	private String createur;
	
	




}
