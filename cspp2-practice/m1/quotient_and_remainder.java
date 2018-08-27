/**
* program to find quotient and remainder.
*/
import java.util.*;
public class quotient_and_remainder {
	/**
	*class containing main method.
	@param args
	*/
	public static void main(String[] args) {
		/**
		*main method implementation.
		*/
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println("enter number to divide\n");
		int b = s.nextInt();
		int rem = a % b;
		int quot = a / b;
		System.out.println("remainder\n"+rem+"quotient\n"+quot);
	}
}