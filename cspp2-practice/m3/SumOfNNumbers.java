import java.util.Scanner;
/**
 * Class for sum of n numbers.
 */
public final class SumOfNNumbers {
	/**
	 * Constructs the object.
	 */
	private SumOfNNumbers() {

	}
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int i = 1;
		/**
		 * while loop for calculations.
		 */
		while(i <= n) {
			sum += i;
			i++;
			//System.out.println(sum);

		}
		System.out.println(sum);
	}
}