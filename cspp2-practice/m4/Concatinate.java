import java.util.Scanner;
/**
 * Class for concatinate.
 */
public final class Concatinate {
	/**
	 * Constructs the object.
	 */
	private Concatinate() {

	}
	/**
	 * { var_description }.
	 */
	public static final String HELLO = "Hello ";
	public static String helloName(final String name) {
		String str = HELLO.concat(name);
		return str;
	}
/**
 * { function_description }.
 *
 * @param      args  The arguments.
 */
public static void main(final String[] args) {
	Scanner s = new Scanner(System.in);
	String name = s.nextLine();
	String str = helloName(name);
	System.out.println(str+"!");
}
}