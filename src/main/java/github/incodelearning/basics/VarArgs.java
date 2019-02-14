package github.incodelearning.basics;

import java.util.ArrayList;
import java.util.List;

public class VarArgs {
    public static void fun(Integer... a) {
        System.out.println("Number of arguments: " + a.length);
        // using for each loop to display contents of a
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }

    public static void fun(String string, Integer... integers) {
        System.out.println("String: " + string);
        System.out.println("Number of integers: " + integers.length);
        for (int i : integers) System.out.print(i + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        // Calling the varargs method with different number
        // of parameters
        fun(100);         // one parameter
        fun(1, 2, 3, 4);  // four parameters
        fun();            // no parameter
        List<Integer> integers = new ArrayList<>();
        fun(integers.toArray(new Integer[integers.size()]));
        fun("test", integers.toArray(new Integer[integers.size()]));
        integers.add(1);
        fun("test", integers.toArray(new Integer[0]));
    }
}
