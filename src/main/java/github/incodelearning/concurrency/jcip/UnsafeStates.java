package github.incodelearning.concurrency.jcip;

import net.jcip.annotations.NotThreadSafe;

/**
 * Publishes supposedly private array of state abbreviations. Publish states in this way is problematic because
 * callers can modify its contents (encapsulation).
 * <p>
 * Publishing an inner class instance implicitly publishes the enclosing instance as well due to the hidden reference.
 */
@NotThreadSafe
public class UnsafeStates {
    private String[] states = new String[] {"AK", "AL", "TX"};

    public String[] getStates() {
        return states;
    }
}
