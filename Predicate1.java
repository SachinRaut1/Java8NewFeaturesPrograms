package Predefined_Function_Interface;

import java.util.function.Predicate;

public class Predicate1 {

	public static void main(String[] args) {
		
		Predicate<Integer> p1=i->i%2==0;
		System.out.println(p1.test(8));
		
		String []s= {"sachin","gopal","raut","wankhede","Ranjwe"};
		//Predicate<String> p=s1->s1.length() > 5;
		Predicate<String> p=s1->s1.length()%2==0;
		for (String s1 : s) 
		{
			if(p.test(s1))
			{
				System.out.println(s1);
			}
			
		}

	}

}
