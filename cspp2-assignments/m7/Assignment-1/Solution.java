import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    public static final int SIX = 6;
    /**
     * input object variable.
     */
    private String input;
    /**
     * Constructs the object.
     *
     * @param      str   The string.
     */
    InputValidator(final String str) {
        this.input = str;
    }
    /**
     * Function which is used for validating.
     *
     * @return     { boolean type }.
     */
    public boolean validateData() {
        final int len = this.input.length();
        if (len >= SIX) {
            return true;
        }
        return false;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * main method.
     * @param      args  args[].
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}


