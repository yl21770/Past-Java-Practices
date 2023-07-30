package data;

import java.util.List;

import javax.persistence.*;

import model.Facility;

public class FacilityService {
   protected EntityManager em;
   
   public FacilityService(EntityManager em) {
      this.em = em;
   }
   
   public Facility createFacility(String name, String description) {
      Facility f0 = new Facility(name, description);
      
      em.getTransaction().begin();
      em.persist(f0);
      em.getTransaction().commit();
      
      return f0;
   }
   
   public Facility updateFacility(int id, String name, String description) {
      Facility f0 = em.find(Facility.class, id);
      
      if(f0 != null) {
    	  em.getTransaction().begin();
    	  f0.setName(name);
    	  f0.setDescription(description);
    	  em.getTransaction().commit();
    	  
    	  return f0;
      }
      
      return null;
   }
   
   public void removeFacility(int id) {
	   Facility f0 = em.find(Facility.class, id);
	   
	   if(f0 != null) {
		   em.getTransaction().begin();
		   em.remove(f0);
		   em.getTransaction().commit();
	   }
   }
   
   public Facility findFacility(int id) {
      Facility f0 = em.find(Facility.class, id);
      return f0;
   }
   
   public List<Facility> listAllFacilities() {
	  TypedQuery<Facility> query = em.createQuery("SELECT f FROM Facility f", Facility.class);
      return query.getResultList();
   }
   
}

