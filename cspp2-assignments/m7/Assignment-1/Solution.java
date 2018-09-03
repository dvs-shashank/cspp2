import java.util.*;
class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
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
		if (len >= 6 ) {
			return true;
		}
		return false;
	}
	
}
public class Solution
{
	public static void main(final String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
