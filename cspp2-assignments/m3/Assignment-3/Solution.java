import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { function_description }.
     *
     * @param      n1    The n 1.
     * @param      n2    The n 2.
     *
     * @return     { description_of_the_return_value }.
     */
    public static final int gcd(final int n1,final int n2) {
        int gcd = 1;
        int min = 0;
        if(n1 > n2) {
            min = n2;
        } else {
            min = n1;
        }
        for (int i = 1; i <= min; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
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
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcd(n1,n2);
        System.out.println(gcd);
    }
}






