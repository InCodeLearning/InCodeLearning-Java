package org.incodelearning.algorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Methods to use LinkedList (Java's LinkedList is doubly linked list) as stack and queue.
 * @author Zexi Jesse Zhuang
 */
public class LinkedListTest {
    /**
     * {@link LinkedList} with default {@link LinkedList#add(Object) add} (equivalent to
     * {@link LinkedList#addLast(Object) addLast}) and {@link LinkedList#remove(Object) remove} (equivalent to
     * {@link LinkedList#removeFirst() removeFirst}) methods behaves like a queue.
     */
    @Test
    public void defaultLinkedListMethodsShouldBehaveLikeQueue() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        LinkedList<Integer> queue = new LinkedList<>();
        for (int num : numbers) queue.add(num);
        for (int num : numbers) queue.addLast(num);
        for (int i = 0; i < numbers.length; i++)
            // ugly cast needed to distinguish method for long or Object
            assertEquals("FIFO queue removing " + i + "th element.", numbers[i], (int) queue.remove());
        for (int i = 0; i < numbers.length; i++)
            assertEquals("FIFO queue removing " + i + "th element.", numbers[i], (int) queue.removeFirst());
    }

    /**
     * <ul>
     * <li>Queue implementations generally do not allow insertion of null elements. LinkedList allows null
     * insertion but not suggested. As null can be returned by {@link Queue#poll()}.</li>
     * <li>The poll method is designed for use when failure is a normal rather than an exception is expected.</li>
     * </ul>
     */
    @Test
    public void useOfNullNotSuggestedButOkWithLinkedList() {
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(null);
        assertEquals("queue contains 1 null element should have a size of 1.", 1, queue2.size());
        assertEquals("remove() must return null for queue with 1 null in it.", null, queue2.remove());
        assertEquals("poll() must return null for empty queue", null, queue2.poll());
    }

}
