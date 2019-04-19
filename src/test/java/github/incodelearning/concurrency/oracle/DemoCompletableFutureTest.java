package github.incodelearning.concurrency.oracle;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class DemoCompletableFutureTest {

    DemoCompletableFuture tbt;

    @Before
    public void setup() {
        tbt = new DemoCompletableFuture();
    }

    @Test
    public void testUseAsFuture() throws ExecutionException, InterruptedException {
        Future<String> completableFuture = tbt.calculateAsync();

        String result = completableFuture.get();
        assertEquals("Hello", result);
    }

    @Test
    public void testResultKnown() throws ExecutionException, InterruptedException {
        assertEquals("Hello", tbt.resultKnown().get());
    }

    @Test(expected = CancellationException.class)
    public void testCancelled() throws ExecutionException, InterruptedException {
        tbt.calculateAsyncWithCancellation().get();
    }

    @Test
    public void testRunSupplyAsync() throws ExecutionException, InterruptedException {
        assertEquals("Hello", tbt.supplyRunAsync().get());
    }
}
