package uemf.org.Repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import uemf.org.Entities.EtudiantDocumentAnnuleEntity;

public class EtudiantDocumentAnnuleRepositoryCustomImpl implements EtudiantDocumentAnnuleRepositoryCustom {
	
	@Autowired
    EntityManager entityManager;

	@Override
	public List<EtudiantDocumentAnnuleEntity> getEtudiantDocumentAnnulesCriteria(String anneScolaire,
			String typeDocument, Long matriculeEtudiant, String nomEtudiant) {
		
		
		   List<EtudiantDocumentAnnuleEntity> listeEtudiantDocumentAnnules=null;
	         
	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

	        CriteriaQuery<EtudiantDocumentAnnuleEntity> cq = cb.createQuery(EtudiantDocumentAnnuleEntity.class);
	        Root<EtudiantDocumentAnnuleEntity> etudiantDocumentAnnules = cq.from(EtudiantDocumentAnnuleEntity.class);
	        
	        

	        List<Predicate> predicates = new ArrayList<>();
	        
	        if (anneScolaire != null && !"".equals(anneScolaire)) {
	            predicates.add(cb.equal(etudiantDocumentAnnules.get("etudiantDocumentEntity").get("anneeScolaire"), anneScolaire ));
	        }
	        if (typeDocument != null && !"".equals(typeDocument)) {
	            predicates.add(cb.equal(etudiantDocumentAnnules.get("etudiantDocumentEntity").get("categorieEntity").get("catDoc"), typeDocument ));
	        }
	       
	        if (matriculeEtudiant != null) {
	            predicates.add(cb.equal(etudiantDocumentAnnules.get("etudiantDocumentEntity").get("etudiantEntity").get("idEtudiant"), matriculeEtudiant ));
	        }
	       
	        if (nomEtudiant != null && !"".equals(nomEtudiant)) {
	            predicates.add(cb.like(etudiantDocumentAnnules.get("etudiantDocumentEntity").get("etudiantEntity").get("nom"), "%" +nomEtudiant +"%"));
	        }

	        cq.where(predicates.toArray(new Predicate[0]));
	        
	        TypedQuery<EtudiantDocumentAnnuleEntity> finalQuery = entityManager.createQuery(cq);

	        listeEtudiantDocumentAnnules= finalQuery.getResultList();
	        
	         return listeEtudiantDocumentAnnules;
	    }

		
}
	
	


