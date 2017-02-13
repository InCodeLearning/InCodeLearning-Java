package github.incodelearning.algorithm;

/**
 * A last in first out (LIFO) stack.
 *
 * @author Zexi Jesse Zhuang
 */
public interface Stack<E> extends Iterable<E> {
    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    int size();

    /**
     * Returns {@code true} if this stack is empty.
     *
     * @return {@code true} if this stack is empty
     */
    boolean isEmpty();

    /**
     * Pushes the element on top of the stack.
     *
     * @param element the element to add
     */
    void push(E element);

    /**
     * Removes and returns the element most recently pushed to this stack.
     *
     * @return the element most recently pushed
     */
    E pop();

    /**
     * Returns but does not remove the element most recently pushed to this stack.
     *
     * @return the element most recently pushed
     */
    E peek();

    // TODO: move below to package interfaces related knowledge point.
    // http://stackoverflow.com/questions/24016962/java8-why-is-it-forbidden-to-define-a-default-method-for-a-method-from-java-lan
    // default String toString();
}
