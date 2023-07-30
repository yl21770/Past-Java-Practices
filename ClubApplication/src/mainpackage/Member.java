package mainpackage;

public class Member extends Person {
	private int memberNumber;

	public Member(String surname, String firstName, String secondName, int memberNumber) {
		super(surname, firstName, secondName);
		this.memberNumber = memberNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", super.toString(), memberNumber);
	}
	
	@Override
	public void show() {
		System.out.printf("Member details: %s\n", toString());
	}
}
