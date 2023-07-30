package mainpackage;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClubApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing");
		
		Person p1 = new Person("Smith", "John", "Henderson");
		Person p2 = new Person("Lee", "Adam");
		
		p1.show();
		p2.show();
		
		Facility f1 = new Facility("Alpha", "default");
		Facility f2 = new Facility("Beta");
		
		f1.show();
		f2.show();
		
		Club club1 = new Club();
		
		Member m1 = club1.addMember("Lee", "Robert", "Weiz");
		m1.show();
		
		Member m2 = club1.addMember("Tan", "Lewis", "Meng");
		Member m3 = club1.addMember("Ong", "Randall", "Yun");
		Member m4 = club1.addMember("Chan", "Jane", "Kang");
		Member m5 = club1.addMember("Lee", "Kate", "Ang");
		
		club1.showMembers();
		
		club1.removeMember(3);
		
		System.out.println("\n=======AFTER REMOVAL=======");
		club1.showMembers();
		
		Member m6 = club1.addMember("Song", "Adam", "Eve");
		club1.removeMember(1);
		club1.removeMember(6);
		
		System.out.println("\n=======AFTER REMOVAL 2=======");
		club1.showMembers();
		
		System.out.println("\n=======EXTRA TESTS=======");
		System.out.printf("Count: %d\n", club1.getMembers().size());
		System.out.println(club1.findMember(2));
		
		Facility f3 = club1.addFacility("Gamma", "abc");
		Facility f4 = club1.addFacility("Delta", "xyz");
		Facility f5 = club1.addFacility("Sigma", "def");
		
		System.out.println("\n=======FACILITY TESTS=======");
		System.out.println(club1.getFacility("Delta"));
		
		club1.removeFacility("Gamma");
		
		System.out.printf("Count: %d\n", club1.getFacilities().size());
		club1.showFacilities();
		
		System.out.println("\n=======ERROR TESTS=======");
		Booking b0 = createBooking(m1, f3, LocalDateTime.now(), LocalDateTime.of(2020, 12, 10, 11, 30, 30));
	
		
		DateTimeFormatter df = Booking.df;
		
		LocalDateTime startDate = LocalDateTime.parse("2022-11-01 10:00", df);
		LocalDateTime endDate = LocalDateTime.parse("2022-11-10 17:00", df);
		
		System.out.println("\n=======BOOKING TESTS=======");
		Booking b1 = createBooking(m1, f3, startDate, endDate);
		System.out.println(b1);
		
		System.out.println("\n=======BOOKING REGISTER TESTS=======");
		BookingRegister br = new BookingRegister();
		
		try {
			br.addBooking(m6, f5, startDate, endDate);
			br.addBooking(m1, f5, startDate.plusMonths(2), endDate.plusMonths(2));
			br.addBooking(m2, f5, startDate.plusMonths(4), endDate.plusMonths(4));
			br.addBooking(m3, f1, startDate.plusMonths(2), endDate.plusMonths(2));
			br.addBooking(m6, f5, startDate, endDate);
		}
		catch(BadBookingException b) {
			System.out.println(b.getMessage());
		}
		
		for(ArrayList<Booking> list:br.getAllBookings().values()) {
			for(Booking bk:list) {
				System.out.println("\n=======================\n" + bk.toString());
			}
		}
		
		System.out.println("\n=======BOOKING REGISTER TESTS 2=======");
		
		for(Booking bk: br.getBookings(f5, startDate.minusMonths(1), endDate.plusMonths(5))) {
			System.out.println(bk + "\n");
		}
		
		br.removeBooking(createBooking(m6, f5, startDate, endDate));
		
		System.out.println("UPDATED COUNT (after removal): " + br.getBookings(f5, startDate.minusMonths(1), endDate.plusMonths(5)).size());
		
		System.out.println("\n=======CLUB BOOKINGS TESTS=======");
		
		club1.addBooking(2, "Delta", startDate, endDate);
		club1.addBooking(4, "Delta", startDate.plusMonths(1), endDate.plusMonths(1));
		
		club1.showBookings("Delta", startDate.minusMonths(1), endDate.plusMonths(2));
		
		System.out.println("\n=======SORTING TESTS=======");
		
		System.out.println("~~~~~~~SORT BY FACILITY NAME~~~~~");
		club1.showFacilitiesSortedByName();
		System.out.println("\n~~~~~~~SORT BY FACILITY DESCRIPTION~~~~~");
		club1.showFacilitiesSortedByDescription();
		System.out.println("~~~~~~~SORT BY FULLNAME~~~~~");
		club1.showMembersSorted();
	}
	
	public static Booking createBooking(Member m, Facility f, LocalDateTime start, LocalDateTime end) {
		try {
			Booking b1 = new Booking(m, f, start, end);
			return b1;
		}
		catch(BadBookingException b){
			System.out.println(b.getMessage());
		}
		
		return null;
	}

}
