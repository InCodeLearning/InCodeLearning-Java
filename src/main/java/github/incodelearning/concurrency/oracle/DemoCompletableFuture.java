package github.incodelearning.concurrency.oracle;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>https://www.baeldung.com/java-completablefuture
 * <p>The Future interface was added in Java 5 to serve as a result of an asynchronous computation, but it did not
 * have any methods to combine these computations or handle possible errors.
 * <p>In Java 8, the CompletableFuture class was introduced. Along with the Future interface, it also implemented
 * the CompletionStage interface. This interface defines the contract for an asynchronous computation step
 * that can be combined with other steps.
 */
public class DemoCompletableFuture {

    /**
     * You can use it as a Future implementation, but with additional completion logic.
     */
    public Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

    /**
     * Then the get method of the Future will never block, immediately returning this result instead.
     */
    public Future<String> resultKnown() {
        return CompletableFuture.completedFuture("Hello");
    }

    /**
     * Param mayInterruptIfRunning has no effect in this implementation as interrupts are not used to control processing.
     */
    public Future<String> calculateAsyncWithCancellation() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.cancel(false);// mayInterruptRunning param has no effect
            return null;
        });

        return completableFuture;
    }

    public Future<String> supplyRunAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture.runAsync(() -> System.out.println("running some calculations"));
        return future;
    }
}
