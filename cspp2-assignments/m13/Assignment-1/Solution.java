import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author : Shashank
 */
class Set {
	/**
	 * global varaible ten.
	 */
	public static final int TEN = 10;
	/**
	 * instance variable size.
	 */
	private int size;
	/**
	 * instance arr[] set.
	 */
	private int[] set;
	/**
	 * Constructs the object.
	 */
	public Set() {
		set = new int[TEN];
		size = 0;
	}
	/**
	 * calcualtes the size of set.
	 *
	 * @return     set size.
	 */
	public int size() {
		return size;
	}
	/**
	 * checks for presence of item.
	 *
	 * @param      item  The item.
	 *
	 * @return     { true or false }.
	 */
	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (set[i] == item) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "{";
		for(int i =0; i < size; i++) {
			str += set[i];
			if (i < size - 1) {
				str += ",";
				str += " ";
			}
		}
		str += "}";
		return str;
	}
	/**
	 * add item to set.
	 *
	 * @param      item  The item.
	 */
	public void add(final int item) {
		//set[size++] = item;
		//int flag = 0;
		int count = 0;
		for (int i =0; i<set.length;i++) {
			if(set[i]!=item) {
				count++;
			}
		}
		if(count == set.length) {
			//size++;
			set[size++] = item;
		}
	}
	/**
	 * add items to set.
	 *
	 * @param      items  The items.
	 */
	public void add(final int[] items) {
		for(int i = 0; i < items.length; i++) {
			add(items[i]);
		}
	}
	/**
	 * intersection of two sets.
	 *
	 * @param      anySet  Any set.
	 *
	 * @return     { common set items }.
	 */
	public Set intersection(final Set anySet) {
        Set temp = new Set();
        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < anySet.set.length; j++) {
                if (set[i] == anySet.set[j]) {
                    temp.add(set[i]);
                }
            }
        }
        return temp;
    }
	/**
	 * coomon elements.
	 *
	 * @param      items  The items
	 *
	 * @return     { common items }.
	 */
	public Set retainAll(final int[] items) {
		//Set tempSet = new Set[items.length];
		//int[] tempList = new int[items.length];
		/*for( int i =0; i < items.length; i++) {
			for(int j =0; j < size; j++) {
				if(items[i].equals(set[j])) {
					tempSet[i].add(set[j]);
				} 
			}
		}*/
		//Arrays.sort(tempList);
		return new Set();
	}
	/**
	 * cartesian product if two sets.
	 *
	 * @param      setObj  The set object
	 *
	 * @return     { int[][] cartesian product }.
	 */
	public int[][] cartesianProduct(final Set setObj) {
		int[][] temp = new int[2][2];
		return temp;
	}
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * helper function to convert string input to int array.
	 *
	 * @param      s     { string input from test case file }
	 *
	 * @return     { int array from the given string }
	 */
	public static int[] intArray(final String s) {
		String input = s;
		if (input.equals("[]")) {
			return new int[0];
		}
		if (s.contains("[")) {
			input = s.substring(1, s.length() - 1);
		}
		return Arrays.stream(input.split(","))
		       .mapToInt(Integer::parseInt)
		       .toArray();
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this set
		Set s = new Set();
		// code to read the test cases input file
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		// check if there is one more line to process
		while (stdin.hasNext()) {
			// read the line
			String line = stdin.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "size":
				System.out.println(s.size());
				break;
			case "contains":
				System.out.println(s.contains(Integer.parseInt(tokens[1])));
				break;
			case "print":
				System.out.println(s);
				break;
			case "add":
				int[] intArray = intArray(tokens[1]);
				if (intArray.length == 1) {
					s.add(intArray[0]);
				} else {
					s.add(intArray);
				}
				break;
			case "intersection":
				s = new Set();
				Set t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(s.intersection(t));
				break;
			case "retainAll":
				s = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				System.out.println(s.retainAll(intArray));
				break;
			case "cartesianProduct":
				s = new Set();
				t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
				break;
			default:
				break;
			}
		}
	}
}
