package github.incodelearning.concurrency.jcip;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * CachedFactorizer, servlet that caches its last request and result.
 * <p>
 * You should be careful not to make the scope of the synchronized block too small. But it is reasonable to exclude
 * from synchronized blocks long-running operations that do not affect shared state.
 * <p>
 * Deciding how big or small to make synchronized blocks require trade offs between simplicity and performance. Thread
 * safety must be guaranteed. A reasonable balance can usually be found. Avoid holding locks during lengthy computations
 * or operations at risk of not completing quickly such as network or console I/O.
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class CachedFactorizer extends GenericServlet implements Servlet {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    // unlike in CountingFactorizer, AtomicLong is not needed here
    // Atomic variables are effective for atomic operations on a single variable
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        // guards check-then-react sequence to see whether we can just return the cached result
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            // factor is the expensive, time consuming operation here
            factors = factor(i);
            // guards updating both cached number and cached factors
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}