package mainpackage;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import java.util.Comparator;

import java.time.LocalDateTime;

public class Club {
	//private Member[] members;
	private List<Member> members;
	private int assigner;
	
	private HashMap<String, Facility> facilities;
	
	private BookingRegister br;
	
	public Club() {
//		members = new Member[0];
		members = new ArrayList<>();
		assigner = 0;
		
		facilities = new HashMap<>();
		
		br = new BookingRegister();
	}
	
//	public Member addMember(String surname, String firstName, String secondName) {
//		assigner += 1;
//		
//		Member newMember = new Member(surname, firstName, secondName, assigner);
//		members = Arrays.copyOf(members, assigner);
//		members[assigner - 1] = newMember;
//		
//		return newMember;
//	}
	
	public Member addMember(String surname, String firstName, String secondName) {
		assigner += 1;
		
		Member newMember = new Member(surname, firstName, secondName, assigner);
		members.add(newMember);
		
		return newMember;
	}
	
//	public void removeMember(int memberNumber) {
//		Member[] temp1 = Arrays.copyOfRange(members, 0, memberNumber - 1);
//		Member[] temp2 = Arrays.copyOfRange(members, memberNumber, members.length);
//		
//		members = new Member[members.length - 1];
//		
//		System.arraycopy(temp1, 0, members, 0, temp1.length);
//		System.arraycopy(temp2, 0, members, temp1.length, temp2.length);
//	}
	
	public void removeMember(int memberNumber) {
		members.remove(findMember(memberNumber));
	}
	
	public void showMembers() {
		for(Member member: members) {
			System.out.printf("Member %d: %s\n", member.getMemberNumber(), member.toString());
		}
	}
	
	public List<Member> getMembers(){
		return members;
	}
	
	public Member findMember(int memberNumber) {
		for(Member member: members) {
			if(member.getMemberNumber() == memberNumber) {
				return member;
			}
		}
		
		return null;
	}
	
	public Facility getFacility(String name) {
		return facilities.get(name);
	}
	
	public HashMap<String, Facility> getFacilities(){
		return facilities;
	}
	
	public Facility addFacility(String name, String description) {
		Facility newFacility = new Facility(name, description);
		facilities.put(name, newFacility);
		
		return newFacility;
	}
	
	public void removeFacility(String name) {
		facilities.remove(name);
	}
	
	public void showFacilities() {
		for(Facility facility: facilities.values()) {
			System.out.printf("Facility %s: %s\n", facility.getName(), facility.getDescription());
		}
	}
	
	public void show() {
		showFacilities();
		showMembers();
	}
	
	public void addBooking(int memberNumber, String fname, LocalDateTime start, LocalDateTime end) {
		Member targetmember = null;
		
		for(Member m: members) {
			if(m.getMemberNumber() == memberNumber) {
				targetmember = m;
			}
		}
		
		Facility facility = facilities.get(fname);
		
		try {
			br.addBooking(targetmember, facility, start, end);
		}
		catch(BadBookingException b) {
			System.out.println(b.getMessage());
		}
	}
	
	public ArrayList<Booking> getBookings(String fname, LocalDateTime start, LocalDateTime end) {
		Facility facility = facilities.get(fname);
		
		ArrayList<Booking> list = br.getBookings(facility, start, end);
		
		return list;
	}
	
	public void showBookings(String fname, LocalDateTime start, LocalDateTime end) {
		ArrayList<Booking> list = getBookings(fname, start, end);
		
		for(Booking b: list) {
			b.show();
			System.out.println();
		}
	}
	
	public void showFacilitiesSortedByName() {
		Collection<Facility> list = facilities.values();
		List<Facility> flist = new ArrayList<>(list);
		
		Collections.sort(flist, new Comparator<Facility>(){
			@Override
			public int compare(Facility f1, Facility f2) {
				return f1.getName().compareTo(f2.getName());
			}
		});
		
		for(Facility f:flist) {
			System.out.println(f);
		}
	}
	
	public void showFacilitiesSortedByDescription() {
		Collection<Facility> list = facilities.values();
		List<Facility> flist = new ArrayList<>(list);
		
		Collections.sort(flist, new Comparator<Facility>(){
			@Override
			public int compare(Facility f1, Facility f2) {
				return f1.getDescription().compareTo(f2.getDescription());
			}
		});
		
		for(Facility f:flist) {
			System.out.println(f);
		}
	}
	
	public void showMembersSorted() {
		Collections.sort(members, new Comparator<Member>(){
			@Override
			public int compare(Member m1, Member m2) {
				String fullname1 = String.format("%s %s %s", m1.getSurname(), m1.getFirstName(), m1.getSecondName());
				String fullname2 = String.format("%s %s %s", m2.getSurname(), m2.getFirstName(), m2.getSecondName());
				return fullname1.compareTo(fullname2);
			}
		});
		
		for(Member m:members) {
			System.out.println(m);
		}
	}
}
