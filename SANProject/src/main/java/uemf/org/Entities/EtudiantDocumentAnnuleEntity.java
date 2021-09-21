package uemf.org.Entities;

import java.util.Date;

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

@Table(name="etudiants_documents_annules")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class EtudiantDocumentAnnuleEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_etudiant_document_annule")
	private Long idEtudiantDocumentAnnule;
	
	@ManyToOne
	@JoinColumn(name= "id_document")
	private EtudiantDocumentEntity etudiantDocumentEntity;
	
	@Column(name= "date_annulation")
	private Date dateAnnulation;
	
	@Column(name= "motif")
	private String motif;
	
//	@ManyToOne
//	@JoinColumn(name= "annule_par")
	@Column(name= "annule_par")
	private String annulePar;
	
	




}
