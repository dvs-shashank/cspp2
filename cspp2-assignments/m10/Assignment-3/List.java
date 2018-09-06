import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Generic list class.
 *
 * @param      <E>   { used for the purpose of generics}.
 */
public class List<E> {
    private E[] list;
    private int size;
    /**
     * Constructs the object.
     */
    public List() {
        // Create a variable of the type Object[]
        list = ((E[])new Object[10]);//Object is the base class for all the classes
        size = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      param  The parameter.
     */
    public List(int param) {
        list = ((E[])new Object[param]);
        size = 0;
    }
    /**
     * resizes the array size.
     */
    private void resize() {
        E[] newList = ((E[])new Object[2 * list.length]);
        System.arraycopy(list, 0, newList, 0, list.length);
        list = newList;
    }
    /**
     * add an item at the end of the list.
     *
     * @param      item  The item.
     */
    public void add(E item) {
        //Inserts the specified element at the end of the list.
        //You can modify the code in this method.
        if (size >= 0 && size < list.length) {
            list[(size++)] = item;
        } else {
            resize();
            add(item);
        }
    }
    /**
     * Adds all elemets into the list.
     *
     * @param      items  The items.
     */
    public void addAll(E[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    /**
     * calculates the size of the list.
     *
     * @return     { size of list }.
     */
    public int size() {
        return size;
    }
    /**
     * removes an element at a particular index.
     *
     * @param      index  The index.
     */
    public void remove(int index) {
        if (index >= 0 && index < size ) {
            for (int i = index; i < size; i++) {
                list[i] = list[i + 1];
            }

            list[size] = null;
            size--;
        }
        else {
            System.out.println("Invalid Position Exception");
        }
    }
    /**
     * gets the index value of element.
     *
     * @param      index  The index.
     *
     * @return     { index value }.
     */
    public E get(int index) {
        if (index >= 0 && index < size) {
            return list[index];
        } else {
            System.out.println("Invalid Position Exception");
            return null;
        }
    }
    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     */
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "[";
        for ( int i = 0; i < size; i++) {
            str += list[i];
            if (i < size - 1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }
    /**
     * check whether item is present or not.
     *
     * @param      item  The item
     *
     * @return     { boolean value. }
     */
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { value of index }.
     */
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
