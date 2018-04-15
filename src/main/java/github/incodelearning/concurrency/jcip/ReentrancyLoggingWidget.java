package github.incodelearning.concurrency.jcip;

/**
 * Intrinsic locks are reentrant. If a thread requests a lock it already hosts, the request succeeds. This differs
 * from default locking behavior for pthreads (POSIX threads) mutexes, which are granted on a per-invocation basis.
 * Reentrancy is implemented by associating with each lock an acquisition count and a owning thread.
 * <p>
 * Renentrancy saves us from deadlock in situation in this class.
 */
public class ReentrancyLoggingWidget extends ReentrancyWidget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}
