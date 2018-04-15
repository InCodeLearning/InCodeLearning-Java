package github.incodelearning.concurrency.jcip;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Synchronizing only the setter is not sufficient: threads calling get can still see stale values.
 * <p>
 * When JVM specification was written, many widely used processor architectures could not efficiently provide
 * atomic 64-bit arithmetic operations. For nonvolatile long and double variables, the JVM is permitted to treat
 * a 64-bit read or write as two separate 32-bit operations. If reads and writes occur in different threads,
 * it's possible to read a nonvolatile long and get back the high 32 bits of one value and low 32 bits of another.
 * <p>
 * Locking can guarantee both visibility and atomicity; volatile variables can only guarantee visibility.
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this") private int value;

    public synchronized int get() { return value; }
    public synchronized void set(int value) { this.value = value; }

}
