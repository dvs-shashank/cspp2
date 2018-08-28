import java.util.Scanner;
/**
 *class.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		int rno = s.nextInt();
		System.out.println("Name :" + name + ",Roll Number : " +rno);
	}
}