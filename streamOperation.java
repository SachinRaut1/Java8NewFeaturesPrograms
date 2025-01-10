package Sream_Operation;

import java.util.List;
import java.util.stream.Stream;

public class streamOperation {

	public static void main(String[] args) {
		
		
//		List<String> values=List.of("one","two","three");
//		
//		Stream<String> strm=values.stream();
		
		List<Integer> list=List.of(10,20,30,40,50);
		
		long count=list.stream().count();
		System.out.println(count);

	}

}
