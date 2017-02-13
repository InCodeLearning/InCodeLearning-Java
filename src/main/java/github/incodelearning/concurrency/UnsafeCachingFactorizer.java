package github.incodelearning.concurrency;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * When there are more than one state variables, use of atomic classes does not help. We cannot update both lastNumber
 * and lastFactors simultaneously. Even though each call to set() is atomic, there is still a window of vulnerability.
 * Similarly the two values cannot be fetched simultaneously.
 * <p>
 * To preserve state consistency, update related state variables in a single atomic operation.
 */
public class UnsafeCachingFactorizer {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) encodeIntoResponse(resp, lastFactors.get());
        else {
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
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
