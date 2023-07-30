package mainpackage;

public class TwoElement<T extends Comparable<T>>{
	T element1, element2;

	public TwoElement(T element1, T element2){
		if(element1.compareTo(element2) > 0) {
			this.element2 = element1;
			this.element1 = element2;
		}
		else {
			this.element1 = element1;
			this.element2 = element2;
		}
	}
	
	public T getElement1() {
		return element1;
	}
	
	public T getElement2() {
		return element2;
	}
}