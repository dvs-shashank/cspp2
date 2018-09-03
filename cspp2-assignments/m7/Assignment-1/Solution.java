import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
	/**
	 * input object variable.
	 */
	private String input;
	/**
	 * Constructs the object.
	 *
	 * @param      input  The input.
	 */
	InputValidator(final String input) {
		this.input = input;
	}
	/**
	 * Function which is used for validating.
	 *
	 * @return     { boolean type }.
	 */
	public boolean validateData() {
		final int len = this.input.length();
		if (len >= 6) {
			return true;
		}
		return false;
	}
}
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * main method.
	 * 
	 * @param      args  args[].
	 */
	public static void main(final String[] args) {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);
    	System.out.println(i.validateData());

    }

}
