import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { var_description }.
     */
    public static final int FOUR = 4;
    /**
    * Constructs the object.
    */
    private Solution() {

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
        findRoots(a, b, c);
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }.
     * @param      b     { parameter_description }.
     * @param      c     { parameter_description }.
     */
    static void findRoots(final int a, final int b, final int c) {
        int two = 2;
        double d = ((b * b) - FOUR * a * c);
        double root1 = (-b + Math.sqrt(d)) / (two * a);
        double root2 = (-b - Math.sqrt(d)) / (two * a);
        System.out.print(root1 + " " + root2);
    }
}


