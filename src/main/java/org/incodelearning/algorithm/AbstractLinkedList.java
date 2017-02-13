package org.incodelearning.algorithm;

/**
 * <p>This class provides a skeletal implementation of the sequential access data store with a default structure below.
 * <p>{@code first element -> second element -> third element -> ... -> last element -> null}
 * <p>Subclasses should implement its own {@code Node} class since each {@code LinkedList} implementation requires
 * different {@code Node} classes. All operations should take constant time.
 *
 * @author Zexi Jesse Zhuang
 */
public abstract class AbstractLinkedList<E> implements Iterable<E> {
    /**
     * For subclass constructor invocation.
     */
    protected AbstractLinkedList() {
    }

    /**
     * Adds the specified element to the first of this linked list.
     *
     * @param element element to be added to this linked list
     */
    public abstract void addFirst(E element);

    /**
     * Removes and returns the first element of the linked list.
     *
     * @return the first element of the linked list
     */
    public abstract E removeFirst();

    /**
     * Retrieves but does not remove the first element of the linked list.
     *
     * @return the fist element of the linked list
     */
    public abstract E first();

    /**
     * Return the number of elements in this linked list.
     *
     * @return the size of the linked list
     */
    public abstract int size();

    /**
     * Returns whether the linked list is empty.
     *
     * @return {@code true} if the linked list is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}
