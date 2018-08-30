import java.util.Scanner;
import java.util.Arrays;
public final class Solution
{
/**
 * Constructs the object.
 */
	private Solution() {

	}
	/**
	 * { Main method }.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(String[] args)
	{
		//System.out.println("enter size of array");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		for (int i = 0;i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[size - 1]);
	}
}
