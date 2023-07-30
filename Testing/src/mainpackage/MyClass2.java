package mainpackage;

import java.util.ArrayList;
import java.util.List;

public class MyClass2 <T>{
	private List<T> data;

	public MyClass2(){
		data = new ArrayList<>();
	}

	public void add(T value){
		data.add(value);
	}

	public T get(){
		T temp = data.get(0);
		data.remove(0);
		return temp;
	}
}
