import java.util.Scanner;
//import org.apache.commons.lang3.StringUtils;
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
    public static final Scanner s = new Scanner(System.in);
    public static int[][] readMatrix(final int m, final int n) {
        // Scanner s = new Scanner(System.in);
        int a[][] = new int[m][n];
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                int val = s.nextInt();
                a[i][j] = val;
            }
            s.nextLine();
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
    public static void main(String[] args) {
        
        int m1 = s.nextInt();
        int n1 = s.nextInt();
        int[][] matrix1 = readMatrix(m1, n1);
        int m2 = s.nextInt();
        int n2 = s.nextInt();
        int[][] matrix2 = readMatrix(m2, n2);
        int[][] res = new int[m1][n1];
        if ( m1 == m2 && n1 == n2) {
            for(int i=0; i < m1; i++) {
                for(int j=0; j < n1; j++) {
                res[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        } else {
            System.out.println("not possible");
        }
        for (int i = 0; i < m1; i++) {
            for(int j =0; j < n1; j++) {
                System.out.print(res[i][j]);
                if(j < n1 - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}