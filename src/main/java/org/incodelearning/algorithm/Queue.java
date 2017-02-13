package org.incodelearning.algorithm;

/**
 * A first in first out (FIFO) queue.
 *
 * @author Zexi Jesse Zhuang
 */
public interface Queue<E> extends Iterable<E> {
    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    int size();

    /**
     * Returns {@code true} if this queue is empty.
     *
     * @return {@code true} if this queue is empty
     */
    boolean isEmpty();

    /**
     * Add the element at the last position of the queue.
     *
     * @param element the element to add
     */
    void enqueue(E element);

    /**
     * Removes and returns the first element of this queue.
     *
     * @return the first element of this queue
     */
    E dequeue();

    /**
     * Returns but does not remove the first element of this queue.
     *
     * @return the first element of this queue
     */
    E peek();
}
