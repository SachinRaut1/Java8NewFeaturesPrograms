package Sream_Operation;

import java.util.List;
import java.util.stream.Collectors;

public class Stream2 {

	public static void main(String[] args) {
		
		
		List<Integer> list=List.of(10,15,20,25,30,35,40,45,11,23,68);
		
		long count = list.stream().count();
		System.out.println(count);
		
		list.stream().filter(i->i%2==0).forEach(even->System.out.println(even));
System.out.println(".............................................................");
		list.stream().filter(n->n%2 !=0).forEach(odd->System.out.println(odd));
		
		System.out.println("....................................................");
		
		List<Integer> addmarks=list.stream().map(i->i+4).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(addmarks);
	}

}
