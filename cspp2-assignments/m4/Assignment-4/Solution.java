/* Given an String, Write a java method that returns
 the decimal value for the given binary string.*/
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { reversing the string. }.
	 *
	 * @param      str   The string.
	 *
	 * @return     { reversed string }.
	 */
	public static String reverseString(final String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		return rev;
	}
	/**
	 * { main method }.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(final String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverseString(s);	
		System.out.println(reverse);
		
	}
}
