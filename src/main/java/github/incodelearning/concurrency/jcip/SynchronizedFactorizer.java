package github.incodelearning.concurrency.jcip;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * <p>
 * This approach is fairly extreme, since it inhibits multiple clients from using the
 * factoring servlet simultaneously at all resulting in unacceptably poor responsiveness.
 * <p>
 * A synchronized method is a shorthand for a synchronized block spans the entire method body, and whose lock is
 * the object on which the method is being invoked. (Static methods use the class object for the lock). Every java
 * object can act as a lock. These built-in locks are called intrinsic locks or monitor locks.
 * <p>
 * For each mutable state variable that may be accessed by more than one thread, all access to the variables must
 * be performed with the same lock held. In this case, we say the variable is guarded by that lock, documented by
 * @GuardedBy annotation below.
 * <p>
 * Merely synchronizing every method, as Vector does, is not enough to render compound actions on a Vector atomic.
 * For example, if (!vector.contains(element)) vector.add(element);
 * This can also lead to liveness (deadlock, starvation, bounded bypass) or performance problems.
 */
@ThreadSafe
public class SynchronizedFactorizer extends GenericServlet implements Servlet {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    public synchronized void service(ServletRequest req,
                                     ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber))
            encodeIntoResponse(resp, lastFactors);
        else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(resp, factors);
        }
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }

    BigInteger[] factor(BigInteger i) {
        return null;
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }
}
