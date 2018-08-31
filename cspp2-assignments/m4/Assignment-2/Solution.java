import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     *
     * @param      m     { parameter_description }
     * @param      n     { parameter_description }
     */
    /**.
     * { var_description }
     */
    public static final Scanner SC = new Scanner(System.in);
    /**
     * Reads a matrix.
     *
     * @param      m     { parameter_description }.
     * @param      n     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public static int[][] readMatrix(final int m, final int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = SC.nextInt();
                a[i][j] = val;
            }
            SC.nextLine();
        }
        return a;
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
        int m1 = SC.nextInt();
        int n1 = SC.nextInt();
        int[][] matrix1 = readMatrix(m1, n1);
        int m2 = SC.nextInt();
        int n2 = SC.nextInt();
        int[][] matrix2 = readMatrix(m2, n2);
        int[][] res = new int[m1][n1];
        if (m1 == m2 && n1 == n2) {
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    res[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    System.out.print(res[i][j]);
                    if (j < n1 - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("not possible");
        }
    }
}

