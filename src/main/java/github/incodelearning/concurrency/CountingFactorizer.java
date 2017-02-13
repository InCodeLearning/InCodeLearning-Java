package github.incodelearning.concurrency;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * To ensure thread safety, compound actions like check-then-act {@link UnsafeCountingFactorizer} and read-modify-write
 * {@link UnsafeCountingFactorizer} must always be atomic. One way is to use existing thread-safe classes atomic
 * classes. Another way is to use locking, java's built-in mechanism for ensuring atomicity.
 */
public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong();

    public long getCount() {
        return count.get();
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(resp, factors);
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
