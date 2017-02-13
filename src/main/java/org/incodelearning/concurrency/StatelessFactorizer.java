package org.incodelearning.concurrency;

import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.math.BigInteger;

/**
 * Very often, thread-safety requirements stem not from a decision to use threads directly but from one to use a
 * facility like the Servlets framework.
 * <p>
 * A stateless servlet. Unpacks the number to be factored from the servlet request, factors it, and packages the result
 * into the servlet response.
 *
 * stateless: this class has no fields and references no fields from other classes. Stateless objects are always
 * thread-safe. Most servlets can be implemented with no state which reduces the burden of making servlets thread-safe.
 * Only when servlets want to remember things from one request to another that the thread safety requirement becomes an
 * issue.
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class StatelessFactorizer extends GenericServlet implements Servlet {

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
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
