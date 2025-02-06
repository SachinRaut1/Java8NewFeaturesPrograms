package java8Newfeatures;

public class invoke_Lambda {

	public static void main(String[] args) {
//		invoke_LambdaExp Square=(n)->(n*n);
//		System.out.println(Square.SquareIt(5));

		invoke_LambdaExp Square=n->n*n;
		System.out.println(Square.SquareIt(5));
		
		
	}

}
