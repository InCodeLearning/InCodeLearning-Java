package github.incodelearning.concurrency.oracle;

import java.util.concurrent.*;

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

        public Future<Integer> sleep() {
            return executor.submit(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Sleeping 1s ...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Sleeping interrupted, but caught and current sleep will finish.");
                    }
                }
                return -1;
            });
        }
    }
}
