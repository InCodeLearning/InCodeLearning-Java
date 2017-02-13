package github.incodelearning.concurrency;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * Like {@link UnsafeSequence}, susceptible to lost updates. The increment operation is not atomic. It has several
 * race conditions that make its results unreliable. A race condition is getting the right answer relies on lucky
 * timing. The most common type of race condition is check-then-act.
 *
 */
public class UnsafeCountingFactorizer {

    // hit counter, number of requests processed
    private long count = 0;

    public long getCount() {
        return count;
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        // looks like single operation, actually read-modify-write operation.
        ++count;
        encondeIntoResponse(resp, factors);
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }

    void encondeIntoResponse(ServletResponse resp, BigInteger[] factors) {

    }
}
