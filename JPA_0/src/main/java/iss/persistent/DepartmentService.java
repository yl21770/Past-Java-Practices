package iss.persistent;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DepartmentService {
	protected EntityManager em;
	
	public DepartmentService(EntityManager em) {
		this.em = em;
	}
	
	public Department createDpt(String name) {
		Department d0 = new Department(name);
		
		em.getTransaction().begin();
		em.persist(d0);
		em.getTransaction().commit();
		
		return d0;
	}
	
	public Department findDpt(int id) {
		Department d0 = em.find(Department.class, id);
		
		return d0;
	}
	
	public List<Department> getAllDpts(){
		TypedQuery<Department> query = em.createQuery("SELECT d FROM Department d", Department.class);
		return query.getResultList();
	}
}
