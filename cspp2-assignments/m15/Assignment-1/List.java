import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * Class List .
 */
public class List {
	/**
	 * constant 25.
	 */
	public static final int SIZE = 25;
	/**
	 * list[].
	 */
	private int[] list;
	/**
	 * size.
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	public List() {
		size = 0;
		list = new int[SIZE];
	}

	/**
	 * adds items to the list.
	 *
	 * @param      item  The item.
	 */
	public void add(final int item) {
		list[size++] = item;
	}
	/**
	 * calculates the size of list.
	 *
	 * @return     { length of list }.
	 */
	public int size() {
		int count = 0;
		// replace the code below to implement the size method
		for (int i = 0; i < size; i++) {
			count++;
		}
		return count;
	}

	/**
	 * removes ana element at an index position.
	 *
	 * @param      index  The index.
	 */
	public void remove(final int index) {
		try {
			for (int i = index; i < size; i++) {
				list[i] = list[i + 1];
			}
			list[size - 1] = 0;
			size--;
		} catch (Exception e) {
			System.out.println("Invalid Position Exception");
		}
	}
	/**
	 * counts the frequency.
	 *
	 * @param      item  The item
	 *
	 * @return     {  frequency }
	 */
	public int count(final int item) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (list[i] == item) {
				count++;
			}
		}
		return count;
	}

	/**
	 * gets the element at particular index.
	 *
	 * @param      index  The index.
	 *
	 * @return     { int type element }.
	 */
	public int get(final int index) {
		return list[index];
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str += list[i];
			if (i < size - 1) {
				str += ",";
			}
		}
		str += "]";
		return str;
	}
	/**
	 * { checks if an element is present or not }.
	 *
	 * @param      item  The item
	 *
	 * @return     { true or false }.
	 */
	public boolean contains(final int item) {
		return indexOf(item) > 0;
	}
	/**
	 * Searches for the first match.
	 *
	 * @param      item  The item
	 *
	 * @return     { returns value }.
	 */
	public int indexOf(final int item) {
		for (int i = 0; i < size; i++) {
			if (list[i] == item) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Adds all elements to list.
	 *
	 * @param      newArray  The new array
	 */
	public void addAll(final int[] newArray) {
		for (int i = 0; i < newArray.length; i++) {
			add(newArray[i]);
		}
	}
	/**
	 * Removes all elements from the list.
	 *
	 * @param      newArray  The new array.
	 */
	public void removeAll(final int[] newArray) {
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < list.length; j++) {
				if (list[j] == newArray[i]) {
					remove(j);
					j--;
				}
			}
		}
	}
	/**
	 * { sublist function implementation. }.
	 *
	 * @param      start  The start.
	 * @param      end    The end.
	 *
	 * @return     { subList }.
	 */
	public List subList(final int start, final int end) {
		List tempList = new List();
		// write the logic for subList
		try {
			if (Math.abs(start - end) == 1) {
				throw new IndexOutOfBoundsException();
			}
			if (start < 0 || end < 0) {
				throw new IndexOutOfBoundsException();
			} else if (start == end || start > end) {
				throw new IndexOutOfBoundsException();
			}
			for (int i = start; i < end; i++) {
				tempList.add(list[i]);
			}
			return tempList;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index Out of Bounds Exception");
		}
		return null;
	}


	/**
	 * { method for checking equality of two lists }.
	 *
	 * @param      listData  The list data
	 *
	 * @return     { boolean }.
	 */
	public boolean equals(final List listData) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			int temp = listData.get(i);
			if (temp == list[i]) {
				count++;
			}
		}
		if (count == size) {
			return true;
		}
		return false;
	}

	/**
	 * clears the whole list.
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			list[i] = 0;
		}
		size = 0;
	}
	/**
	 * Main method.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(final String[] args) {
		// create an object of the list to invoke methods on it
		List l = new List();

		// code to read the test cases input file
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		// check if there is one more line to process
		while (stdin.hasNext()) {
			// read the line
			String line = stdin.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "count":
				System.out.println(l.count(Integer.parseInt(tokens[1])));
				break;
			case "add":
				if (tokens.length == 2) {
					String[] t = tokens[1].split(",");
					if (t.length == 1) {
						l.add(Integer.parseInt(tokens[1]));
					}
				}
				break;
			case "size":
				System.out.println(l.size());
				break;
			case "print":
				System.out.println(l);
				break;
			case "remove":
				if (tokens.length == 2) {
					l.remove(Integer.parseInt(tokens[1]));
				}
				break;
			case "indexOf":
				if (tokens.length == 2) {
					System.out.println(l.indexOf(
					                       Integer.parseInt(tokens[1])));
				}
				break;
			case "get":
				if (tokens.length == 2) {
					System.out.println(l.get(
					                       Integer.parseInt(tokens[1])));
				}
				break;
			case "contains":
				if (tokens.length == 2) {
					System.out.println(l.contains(
					                       Integer.parseInt(tokens[1])));
				}
				break;
			case "addAll":
				if (tokens.length == 2) {
					String[] t1 = tokens[1].split(",");
					int[] temp = new int[t1.length];
					for (int i = 0; i < temp.length; i++) {
						temp[i] = Integer.parseInt(t1[i]);
					}
					l.addAll(temp);
				}
				break;
			case "removeAll":
				if (tokens.length == 2) {
					String[] t2 = tokens[1].split(",");
					int[] a = new int[t2.length];
					for (int i = 0; i < t2.length; i++) {
						a[i] = Integer.parseInt(t2[i]);
					}
					l.removeAll(a);
				}
				break;
			case "subList":
				if (tokens.length != 2) {
					break;
				}
				String[] arrstring3 = tokens[1].split(",");
				List object = l.subList(Integer.parseInt(arrstring3[0]),
				                        Integer.parseInt(arrstring3[1]));
				if (object != null) {
					System.out.println(object);
				}
				break;
			case "equals":
				if (tokens.length == 2) {
					String[] lt = tokens[1].split(",");
					List l2 = new List();
					for (int k = 0; k < lt.length; k++) {
						l2.add(Integer.parseInt(lt[k]));
					}
					System.out.println(l.equals(l2));
				}
				break;
			case "clear":
				l.clear();
				break;
			default:
				break;
			}
		}
	}
}


