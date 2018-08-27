/**
* program to find quotient and remainder.
*/
import java.util.*;
public class conversion {
	/**
	*class containing main method.
	@param args
	*/
	public static void main(String[] args) {
		/**
		*main method implementation.
		*/
		Scanner s = new Scanner(System.in);
		System.out.println("enter temperature in celcius\n");
		int a = s.nextInt();
		double b = 0.0;
		b = (a * 1.8) + 32;
		System.out.println("temperature in fahrenheit is " +b);
	}
}