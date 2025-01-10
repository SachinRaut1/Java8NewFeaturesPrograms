package java8Newfeatures;

import java.util.function.Function;
import java.util.function.Predicate;

public class lambdaExpression {
	//1
	public void m1()
	{
		System.out.println("this is lambda expression");
	}
	
	public static void main(String[] args) {
		lambdaExpression le=new lambdaExpression();
		le.m1();
		
		
		Function<Integer, Integer> f=i-> i*i;
		System.out.println("the squre of 2 is:"+f.apply(2));
		System.out.println("the squre of 4 is:"+f.apply(4));
		
		Predicate<Integer> p=i->i%2==0;
		System.out.println("even:"+p.test(2));
		System.out.println("odd:"+p.test(5));
		
		Predicate<Integer> p1=i->i>=18;
		boolean test=p1.test(25);
		if(test)
		{
			System.out.println("eligibe");
		}
		else
		{
			System.out.println("not eligible");
		}
		
		
	}
}
