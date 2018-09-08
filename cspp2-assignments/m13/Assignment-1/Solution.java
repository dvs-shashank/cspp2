import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Shashank
 */
class Set {
	public static final int TEN = 10;
	private int size;
	private int[] set;
	public Set() {
		set = new int[TEN];
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean contains(int item) {
		for (int i = 0; i < size; i++) {
			if (set[i] == item) {
				return true;
			}
		}
		return false;
	}
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
	public void add(int item) {
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
	public void add(int[] items) {
		for(int i = 0; i < items.length; i++) {
			add(items[i]);
		}
	}
	public Set intersection(Set anySet) {
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
	/*public Set intersection(Set setObj) {
		Set tempSet = new Set();
		for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < setObj.set.length; j++) {
                if (set[i] == setObj.set[j]) {
                    tempSet.set[i] = set[i];
                }
            }
        }
        return tempSet;

		//Set[] tempSet = new Set[setObj.size()]; 
		/*for( int i = 0; i < setObj.size(); i++) {
			for(int j = 0; j < this.size(); j++) {
				if((setObj.get(i)).equals(this.get(j))) {
					tempSet.add(this.get(j));
				}
			}
		}*/
		//return new Set();
	//}
	public Set retainAll(int[] items) {
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
	public int[][] cartesianProduct(Set setObj) {
		int[][] temp = new int[2][5];
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
