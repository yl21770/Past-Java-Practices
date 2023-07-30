package data;

import java.util.*;
import javax.persistence.*;

import model.*;

public class MemberService {
	protected EntityManager em;
	
	public MemberService(EntityManager em) {
		this.em = em;
	}
	
	public Member createMember(String srn, String fn, String scn, int id) {
		Member m0 = new Member(srn, fn, scn, id);
		
		em.getTransaction().begin();
		em.persist(m0);
		em.getTransaction().commit();
		
		return m0;
	}
	
	public Member updateMember(int id, String srn, String fn, String scn) {
		Member m0 = em.find(Member.class, id);
		
		if(m0 != null) {
			em.getTransaction().begin();
			m0.setSurname(srn);
			m0.setFirstName(fn);
			m0.setSecondName(scn);
			m0.setMemberNumber(id);
			em.getTransaction().commit();
			
			return m0;
		}
		
		return null;
	}
	
	public void removeMember(int id) {
		Member m0 = em.find(Member.class, id);
		
		if(m0 != null) {
			em.getTransaction().begin();
			em.remove(m0);
			em.getTransaction().commit();
		}
	}
	
	public Member findMember(int id) {
		return em.find(Member.class, id);
	}
	
	public List<Member> listAllMembers(){
		return em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
	}
}
