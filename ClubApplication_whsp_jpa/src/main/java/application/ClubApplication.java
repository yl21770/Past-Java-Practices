package application;

import java.util.*;

import javax.persistence.*;

import data.*;
import model.*;

public class ClubApplication {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAWorkshop");
	    EntityManager em = emf.createEntityManager();
	    FacilityService fs = new FacilityService(em);
	    MemberService ms = new MemberService(em);
	
	    //testFacility(emf, em, fs);
	      
	    testMember(emf, em, ms);
	}
	   
	public static void testMember (EntityManagerFactory emf, EntityManager em, MemberService ms) {
		Member result = ms.createMember("Richard", "Lee", "Aus", 1);
		result.show();
		
		result = ms.createMember("Robert", "Lim", "Oz", 2);
		result.show();
		
		result = ms.updateMember(1, "Richard", "Liu", "Aus");
		result.show();
		
		ms.findMember(2).show();
		
		ms.listAllMembers().forEach(System.out::println);
	}

	public static void testFacility(EntityManagerFactory emf, EntityManager em, FacilityService fs) {
		Facility result = fs.createFacility("alpha", "abc");	      
	    System.out.printf("Created facility: %s, %s\n", result.getName(), result.getDescription());
	      
	    result = fs.createFacility("beta", "def");	      
	    System.out.printf("Created facility: %s, %s\n", result.getName(), result.getDescription());
	      
	    result = fs.updateFacility(1, "gamma", "xyz");      
	    System.out.printf("Updated facility: %s, %s\n", result.getName(), result.getDescription());
	      
	    result = fs.findFacility(2);      
	    System.out.printf("Found facility: %s, %s\n", result.getName(), result.getDescription());
	      
	    List<Facility> list = fs.listAllFacilities();
	    for(Facility f: list) {
	    	System.out.printf("Found facility: %s, %s\n", f.getName(), f.getDescription());
	    }
	}
}

