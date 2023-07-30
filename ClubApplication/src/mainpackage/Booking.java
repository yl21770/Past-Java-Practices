package mainpackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {
	private Member member; 
	private Facility facility;
	private LocalDateTime startDate, endDate;
	
	public static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public Booking(Member member, Facility facility, LocalDateTime startDate, LocalDateTime endDate) throws BadBookingException {
		if(member == null || facility == null || startDate == null || endDate == null || startDate.isAfter(endDate)) {
			throw new BadBookingException("Invalid booking input!");
		}
		
		this.member = member;
		this.facility = facility;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Member getMember() {
		return member;
	}

	public Facility getFacility() {
		return facility;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public boolean overlaps(Booking otherBooking) {
		if(this.facility == otherBooking.facility) {
			boolean overlap = (this.startDate.isAfter(otherBooking.startDate) && this.startDate.isBefore(otherBooking.endDate)) ||
							(this.endDate.isBefore(otherBooking.endDate) && this.endDate.isAfter(otherBooking.startDate)) ||
							(this.startDate.isEqual(otherBooking.startDate)) ||
							(this.endDate.isEqual(otherBooking.endDate));
			if(overlap) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Booking Details-\n" +
			member.toString() + "\n" + 
			facility.toString() + "\n" + 
			"Start Date: " + df.format(startDate) + 
			"; End Date: " + df.format(endDate);
	}
	
	public void show() {
		System.out.println("Booking Details-\n" +
			member.toString() + "\n" + 
			facility.toString() + "\n" + 
			"Start Date: " + df.format(startDate) + 
			"; End Date: " + df.format(endDate));
	}
}
