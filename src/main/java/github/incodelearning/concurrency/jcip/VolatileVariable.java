package github.incodelearning.concurrency.jcip;

/**
 * JVM provides volatile variables, a weaker form (lighter weight) of synchronization. Access requires no locking
 * and so cannot cause the executing thread to block. They behave roughly like SynchronizedInteger class.
 * The compiler and runtime are put on notice that this variable is shared and operations should not be reordered
 * with other memory operations. Volatile variables are not cached in registers or in caches where they are hidden
 * from other processors. So read always the most recent write by any thread. Most common use for volatile variables
 * is as a completion, interruption, or status flag.
 * <p>
 * Locking can guarantee both visibility and atomicity; volatile variables can only guarantee visibility.
 * <p>
 * The semantics of volatile ar not strong enough to make the increment operation (count++) atomic, unless you
 * guarantee that the variable is only written from a single thread. Atomic variables can often be used as better
 * volatile variables.
 */
public class VolatileVariable {
    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep)
            countSomeSheep();
    }

    void countSomeSheep() {
        // One, two, three...
    }
}
