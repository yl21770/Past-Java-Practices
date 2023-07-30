package mainpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyClass<T>{
	private List<T> list;

	public MyClass(){
		this.list = new ArrayList<>();
	};

	public void add(T value){
		list.add(value);
		list = list.stream()
			.sorted()
			.collect(Collectors.toList());
	}

	public T get(){
		T value = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return value;
	}
}