package org.incodelearning.algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>Default linked list implementation, singly linked. Providing access to the first element only.
 * <p>All operations take constant time except iterator O(n).
 * ToDo: check all methods to see if exception and empty list handling.
 */
public class SinglyLinkedList<E> extends AbstractLinkedList<E> implements Stack<E> {

    protected int N;
    protected Node<E> first;

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(first);
    }

    private class LinkedListIterator<E> implements Iterator<E> {
        private Node<E> current;

        /**
         * Does not compile without constructor argument, type mismatch.
         */
        public LinkedListIterator(Node<E> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E element = current.element;
            current = current.next;
            return element;
        }
    }

    protected static class Node<E> {
        protected E element;
        protected Node<E> next;
    }

    /**
     * Initializes an empty singly linked list.
     */
    public SinglyLinkedList() {
        N = 0;
        first = null;
    }

    /**
     * Pushes the element on top of the stack represented by this singly linked list.
     *
     * @param element the element to add
     */
    public void push(E element) {
        addFirst(element);
    }

    /**
     * Adds the element to the first position of this linked list.
     *
     * @param element element to be added to this linked list
     */
    public void addFirst(E element) {
        Node<E> oldFirst = first;
        Node<E> first = new Node<E>();
        first.element = element;
        first.next = oldFirst;
        N++;
    }

    /**
     * Removes and returns the element most recently pushed to this stack.
     *
     * @return the element most recently pushed
     */
    public E pop() {
        return removeFirst(true);
    }

    @Override
    public E peek() {
        return first();
    }

    @Override
    public E first() {
        if (isEmpty()) throw new NoSuchElementException("Linked list is empty.");
        return first.element;
    }

    private E removeFirst(boolean fromStack) {
        if (isEmpty() && fromStack) throw new NoSuchElementException("Stack underflow.");
        return removeFirst();
    }

    public E removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Linked list is empty.");
        Node<E> oldFirst = first;
        first = first.next;
        N--;
        return oldFirst.element;
    }

    /**
     * Returns the number of elements in this singly linked list.
     *
     * @return the number of elements in this singly linked list
     */
    public int size() {
        return N;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("stack: ");
        for (E element : this) s.append(element + " ");
        return s.toString();
    }
}
