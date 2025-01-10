package Predefined_Function_Interface;

import java.util.function.Predicate;

public class Predicate2E_Odd {

	public static void main(String[] args) {
		
		int[]arr= {0,5,25,30,35,4,45,50,31,91,71};
		Predicate<Integer> p=i->i%2==0;
		Predicate<Integer> p1=i->i > 5;
		for (int x1 : arr) 
		{
			if(p.negate().test(x1))
			{
				System.out.println(x1);
			}
			
		}
		//System.out.println(p.test(arr[8]));

	}

}
