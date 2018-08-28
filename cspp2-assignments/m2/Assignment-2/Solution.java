import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/**
	 * { function_description }.
	 *
	 * @param      a     { parameter_description }.
	 * @param      b     { parameter_description }.
	 * @param      c     { parameter_description }.
	 */
	static void rootsOfQuadraticEquation(int a, int b, int c) {
		int four = 4;
		int two = 2;
		double root1 = (-b + Math.sqrt((b * b) - four * a * c)) / (two * a);
		double root2 = (-b - Math.sqrt((b * b) - four * a * c)) / (two * a);
		System.out.print(root1+ " " +root2);
	}
}