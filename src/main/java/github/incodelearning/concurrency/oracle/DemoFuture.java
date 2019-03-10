package github.incodelearning.concurrency.oracle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The Future class represents a future result of an asynchronous computation – a result that will eventually appear
 * in the Future after the processing is complete.
 */
public class DemoFuture {
    public class SquareCalculator {
        private ExecutorService executor;

        public SquareCalculator() {
            executor = Executors.newSingleThreadExecutor();
        }

        public SquareCalculator(int nThreads) {
            executor = Executors.newFixedThreadPool(nThreads);
        }

        public Future<Integer> calculate(Integer input) {
            return executor.submit(() -> {
                Thread.sleep(1000);
                return input * input;
            });
        }
    }
}
