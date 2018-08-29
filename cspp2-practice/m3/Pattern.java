/**
 * Class for pattern.
 */
public final class Pattern {
	/**
	 * Constructs the object.
	 */
	private Pattern() {

	}
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(String[] args) {
		/**
		 * { loops for printing pattern }.
		 */
		for(int i = 1; i <= 5; i++)
		{
			for (int j = 1;j <= i ;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}