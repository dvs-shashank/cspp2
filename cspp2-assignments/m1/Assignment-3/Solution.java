import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	public static final int DF = 1.8;
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double degreesCelsius = scan.nextDouble();
		calculateFromDegreesToFarenheit(degreesCelsius);
	}
	/**
	 * Calculates the from degrees to farenheit.
	 *
	 * @param      degreesCelsius  The degrees celsius
	 */
	static void calculateFromDegreesToFarenheit(double degreesCelsius) {
		double result = 0.0;
		result = (degreesCelsius * DF) + 32;
		System.out.println(result);
	}
}