package org.incodelearning.algorithm;

/**
 * A singly linked list that maintains the two nodes at each end of the list, i.e., the first and last
 * elements of the list.
 *
 * @author Zexi Jesse Zhuang
 */
public class DoubleEndedSinglyLinkedList<E> extends SinglyLinkedList<E> implements Stack<E>, Queue<E> {

    private Node<E> last;

    /**
     * Add the element at the last position of the queue.
     *
     * @param element the element to add
     */
    @Override
    public void enqueue(E element) {

    }

    /**
     * Removes and returns the first element of this queue.
     *
     * @return the first element of this queue
     */
    @Override
    public E dequeue() {
        return null;
    }
}
