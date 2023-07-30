package mainpackage;

import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class BookingRegister {
	private HashMap<Facility, ArrayList<Booking>> bookings;
	
	public BookingRegister() {
		this.bookings = new HashMap<>();
	}
	
	public HashMap<Facility, ArrayList<Booking>> getAllBookings(){
		return bookings;
	}
	
	public ArrayList<Booking> getBookings(Facility f, LocalDateTime start, LocalDateTime end){
		ArrayList<Booking> temp = new ArrayList<>();
		
		ArrayList<Booking> list = bookings.get(f);
		
		for(Booking bk: list) {
			boolean withinRange = (bk.getStartDate().isEqual(start) && bk.getEndDate().isEqual(end)) ||
								(bk.getStartDate().isAfter(start) && bk.getEndDate().isBefore(end));
			if(withinRange) {
				temp.add(bk);
			}
		}
		
		return temp;
	}
	
	public void removeBooking(Booking bk) {
		ArrayList<Booking> temp = bookings.get(bk.getFacility());
		Booking target = null;
		
		for(Booking b: temp) {
			boolean same = b.getMember().equals(bk.getMember())&& 
						b.getFacility().equals(bk.getFacility()) && 
						b.getStartDate().isEqual(bk.getStartDate()) && 
						b.getEndDate().isEqual(bk.getEndDate());
			
			if(same) {
				target = b;
			}
		}
		
		temp.remove(target);
		bookings.put(bk.getFacility(), temp);
	}
	
	public void addBooking(Member m, Facility f, LocalDateTime start, LocalDateTime end) throws BadBookingException {
		Booking b0 = null;
		
		try {
			b0 = new Booking(m, f, start, end);
		}
		catch(BadBookingException b) {
			System.out.println(b.getMessage());
		}
		
		ArrayList<Booking> list = bookings.get(f);
		
		if(list == null) {
			list = new ArrayList<>();
		}
		else {
			for(Booking bk : list) {
				if(bk.overlaps(b0)) {
					throw new BadBookingException("Invalid booking input!");
				}
			}
		}
		
		list.add(b0);
		bookings.put(f, list);
	}
}
