package uemf.org.Repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uemf.org.Entities.EtudiantDocumentAnnuleEntity;
import uemf.org.Entities.EtudiantDocumentEntity;

@Repository
public class EtudiantDocumentRepositoryCustomImpl implements EtudiantDocumentRepositoryCustom {
	
	@Autowired
    EntityManager entityManager;
	
	public  List<EtudiantDocumentEntity> getEtudiantDocumentCriteria(String anneScolaire, String typeDocument
			 ,Long matriculeEtudiant, String nomEtudiant){
		
		         List<EtudiantDocumentEntity> listEtudiantDocument=null;
		         CriteriaBuilder  cb = entityManager.getCriteriaBuilder();

		        CriteriaQuery<EtudiantDocumentEntity> cq = cb.createQuery(EtudiantDocumentEntity.class);
		        Root<EtudiantDocumentEntity> etudiantDocumentRoot = cq.from(EtudiantDocumentEntity.class);
		        		

		        List<Predicate> predicates = new ArrayList<>();
		        
		        if (anneScolaire != null && !"".equals(anneScolaire)) {
		            predicates.add(cb.equal(etudiantDocumentRoot.get("anneeScolaire"), anneScolaire ));
		        }
		        if (typeDocument != null && !"".equals(typeDocument)) {
		            predicates.add(cb.equal(etudiantDocumentRoot.get("categorieEntity").get("catDoc"), typeDocument ));
		        }
		       
		        if (matriculeEtudiant != null) {
		            predicates.add(cb.equal(etudiantDocumentRoot.get("etudiantEntity").get("idEtudiant"), matriculeEtudiant ));
		        }
		       
		        if (nomEtudiant != null && !"".equals(nomEtudiant)) {
		            predicates.add(cb.like(etudiantDocumentRoot.get("etudiantEntity").get("nom"), "%" +nomEtudiant +"%"));
		            
		 
		        }

	            predicates.add(cb.equal(etudiantDocumentRoot.get("isAnnule"), false ));

		        
		        cq.where(predicates.toArray(new Predicate[0]));

		        TypedQuery<EtudiantDocumentEntity> finalQuery = entityManager.createQuery(cq);

		        listEtudiantDocument= finalQuery.getResultList();
		        
		         return listEtudiantDocument;
		    }

	 }

