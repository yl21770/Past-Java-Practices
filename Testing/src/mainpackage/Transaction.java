package mainpackage;

public class Transaction implements Comparable<Transaction>{
	private Trader trader;
	 private int year;
	 private int value;

	 public Transaction(Trader trader, int year, int value) {
	 this.trader = trader;
	 this.year = year;
	 this.value = value;
	 }

	 public Trader getTrader() {
		return trader;
	}



	public int getYear() {
		return year;
	}



	public int getValue() {
		return value;
	}



	@Override
	 public String toString() {
	 return trader + ", year: " + year + ", value: " + value;
	 }
	 
	 @Override
	 public int compareTo(Transaction other) {
		 int i = this.trader.getName().compareTo(other.getTrader().getName());
		 
		 if(i != 0) {
			 return i;
		 }
		 else {
			 return Integer.compare(this.year, other.getYear());
		 }
	 }
}
