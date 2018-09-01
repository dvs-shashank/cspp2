import java.util.Scanner;
/**
 * Write a java program to round the.
 * elements of a matrix to the nearest 100.
 *
 * @author : shashank.
 */
final class Solution {
    /**
     * hundred global variable int type.
     */
    public static final int HUNDRED = 100;
    /**
     * hundred global variable double type.
     */
    public static final double HUNDREDS = 100.0;
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used.
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded.
     * @param      rows     Number of rows.
     * @param      columns     Number of columns.
     *
     * @return     Matrix of the rounded elements.
     */
    static int[][] roundHun(final int[][] a, final int rows, final int columns) {
    int[][] rounded = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            rounded[i][j] = (int) Math.round(a[i][j] / HUNDREDS) * HUNDRED;
        }
    }
    return rounded;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHun(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
