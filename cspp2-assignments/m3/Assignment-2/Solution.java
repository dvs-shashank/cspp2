
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
	 * Counts the number of 7.
	 *
	 * @param      n     { number given from user }.
	 *
	 * @return     Number of 7.
	 */
	public static int count7(int n) {
		int count = 0;
		//int temp = 0;
		for (int i = 1;i <= n ;i++ ) {
			int temp_i = i;
			while(temp_i > 1){
				int r = temp_i % 10;
				if (r == 7) {
					count += 1;
				}
				temp_i = temp_i / 10;
			}
		}
		return count;
	}

/* Fill the main function to print the number of 7's between 1 to n*/
/**
 * { function_description }.
 *
 * @param      args  The arguments
 */
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int res = count7(n);
       	System.out.println(res);
        
    }
}