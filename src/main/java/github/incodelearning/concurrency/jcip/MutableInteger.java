package github.incodelearning.concurrency.jcip;

import net.jcip.annotations.NotThreadSafe;

/**
 * Stale Data. Reading data without synchronization is analogous to using the READ_UNCOMMITTED isolation level
 * in a database, where you are willing to trade accuracy with performance. In case of synchronization,
 * you are trading away a greater degree of accuracy, since visible value of shared variable can be
 * arbitrarily stale.
 */
@NotThreadSafe
public class MutableInteger {
    private int value;

    public int  get() { return value; }
    public void set(int value) { this.value = value; }
}
