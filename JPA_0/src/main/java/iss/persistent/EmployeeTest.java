package iss.persistent;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest {
	public static void main (String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("JPA01");
		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);
		DepartmentService dservice = new DepartmentService(em);
		
		Department d0 = dservice.createDpt("Accounting");
		Department d1 = dservice.createDpt("IT");
		
		// Create and persist an employee
		em.getTransaction().begin();
		Employee emp = service.createEmployee(159, "Emily Tan", 55000, d0);
		em.getTransaction().commit();
		System.out.println("Persisteed " + emp);
		
		em.getTransaction().begin();
		emp = service.createEmployee(158, "Randall Tan", 60000, d1);
		em.getTransaction().commit();
		System.out.println("Persisteed " + emp);
		
		em.getTransaction().begin();
		emp = service.createEmployee(157, "John Tan", 70000, d1);
		em.getTransaction().commit();
		System.out.println("Persisteed " + emp);
		
		// Find all employees
		List<Employee> emps = service.findAllEmployees();
		for (Employee e : emps) {
			System.out.println("Found employee: " + e);
		}
		
		// Update an employee
		em.getTransaction().begin();
		Employee updatedEmp = service.raiseEmployeeSalary(158, 3000);
		em.getTransaction().commit();
		System.out.println("Updated " + updatedEmp);
		
		// Find an employee
		Employee e = service.findEmployee(158);
		System.out.println("Found employee: " + e);
		
		System.out.println("===============MAIN TEST===============");
		Department dx = dservice.findDpt(1);
		em.refresh(dx);
		
		System.out.println(dx.getEmployees());
	}
}
