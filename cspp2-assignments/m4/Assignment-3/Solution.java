// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution
{
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { binaryToDecimal method }.
	 *
	 * @param      s     { String of binary numbers }.
	 *
	 * @return     { String of integer }.
	 */
	public static String binaryToDecimal(final String s) {
		int binary = 1;
		int decimal = 0;
		for (int i = s.length() - 1; i >=0; i--) {
			if (s.charAt(i) == '1') {
				decimal += binary;
			}
			binary = binary * 2;
		}
		String res = Integer.toString(decimal);
	return res;
	}
	
	/**
	 * { main method}.
	 *
	 * @param      args  The arguments of string type.
	 */
	public static void main(final String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}

}
