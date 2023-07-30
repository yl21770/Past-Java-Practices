package iss.persistent.jpql.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class DataService {

   protected EntityManager em;

   public DataService(EntityManager entityManager) {
      em = entityManager;
   }

   public List<Student> findAllStudents() {
      String q = "SELECT s FROM Student s";
      
      return (List<Student>) em.createQuery(q).getResultList();
   }
   
   public List<Student> findAllStudentsSortMatric(){
	   String q = "SELECT s FROM Student s ORDER BY s.matricNo";
	     
	   return (List<Student>) em.createQuery(q).getResultList();
   }
   
   public List<Student> findAllNStudents(){
	   String q = "SELECT s FROM Student s WHERE s.name LIKE '%n'";
	   
	   return (List<Student>) em.createQuery(q).getResultList();
   }
   
   public List<Student> findAllCAPStudents(){
	   String q = "SELECT s FROM Student s WHERE s.cap >= 2.0";
	  
	   return (List<Student>) em.createQuery(q).getResultList();
   }
   
   public List<Student> findAllStudentsOnPage2(){
	   String q = "SELECT s FROM Student s";
	   
	   return (List<Student>) em.createQuery(q).setFirstResult(4).setMaxResults(4).getResultList();
   }
   
   public List<Student> findAllMarvelCAPStudents(){
	   String q = "SELECT s FROM Student s WHERE s.department.name = 'Marvel' AND s.cap > 2.5";
	   
	   return (List<Student>) em.createQuery(q).getResultList();
   }
   
   public List<Student> findAllManStudentsWithModules(){
	   String q = "SELECT DISTINCT s FROM Student s JOIN s.modules m WHERE s.name LIKE '%man%'";
	   
	   return (List<Student>) em.createQuery(q).getResultList();
   }
   
   public List<Department> findAllCAPDepartments(){
	   String q = "SELECT d FROM Department d JOIN d.students s GROUP BY d HAVING AVG(s.cap) > 2.5";
	   
	   List<Department> result  = (List<Department>) em.createQuery(q).getResultList();
	   
	   return result;
   }
   
   public Student forTesting(){
	   String q = "SELECT s FROM Student s WHERE s.name = 'Flash'";
	   
	   return (Student) em.createQuery(q).getSingleResult();
   }
}
