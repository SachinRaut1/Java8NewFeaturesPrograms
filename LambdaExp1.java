package java8Newfeatures;
import java.util.function.*;

public class LambdaExp1{
	
	//normally we write a code like this
	
	

	
	//but using lambda expression we write code like this
	//means concise code
	//it is an anonymous means 
	//ex:=>public void m1()
	//() -> {syso("hello");} if there is a single line {} are not mandatory==>
	//()->syso("helo");
	//if there is a multiple line of code or (return) type in that case {}are mandatory 
	
	public static void main(String[] args) {
		Lambda_exp add1=(a,b)->(a+b);
		 System.out.println(add1.add(100,200)); 
		
		


	}

}
