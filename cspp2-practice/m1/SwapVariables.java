/**
*This is a program to swap variables.
*/
import java.util.*;
public class SwapVariables {
	/**
	*This is class containing main method.
	*@param args
	*/
	public static void main(String[] args) {
		/**
		*Main method implementation.
		*/
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println("before swapped the  values are "+a+"\n"+b);
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("after swapped the  values are " +a+"\n"+b);	
	}
}