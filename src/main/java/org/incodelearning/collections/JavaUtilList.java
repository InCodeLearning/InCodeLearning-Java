package org.incodelearning.collections;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>{@code java.util.List} is an interface. Implementing classes include AbstractList, ArrayList, LinkedList, Stack,
 * Vector and others.
 * <p>
 * <p>{@code java.util.ArrayList} extends AbstractList but also implements List although AbstractList already implements
 * List. This seems redundant and it might be for the purpose of clarity or documentation to stress that ArrayList is
 * a type of List.
 *
 * @author Zexi Jesse Zhuang
 */
public class JavaUtilList {

    /**
     * The first one is a nested class which extends AbstractList and the add() operation would just throw
     * an UnsupportedOperationException in the implementation of the base class AbastractList.
     */
    private static void ArraysAsList() {
        System.out.println(Arrays.asList().getClass());
        System.out.println(ArrayList.class);
    }

    public static void main(String[] args) {
        ArraysAsList();
    }
}
