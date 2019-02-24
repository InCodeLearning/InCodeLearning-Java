package github.incodelearning.concurrency.oracle;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DemoFutureTest {
    private DemoFuture.SquareCalculator tbt;

    @Before
    public void setup() {
        tbt = new DemoFuture().new SquareCalculator();
    }

    @Test
    public void testGetAfterFutureDone() throws InterruptedException, ExecutionException {
        Future<Integer> future = tbt.calculate(10);

        int timeInMillis = 0;
        while(!future.isDone()) {
            System.out.println(timeInMillis + " Calculating...");
            Thread.sleep(300);
            timeInMillis += 300;
        }

        Integer result = future.get();
        assertEquals(new Integer(100), result);
    }

    @Test
    public void testGetFutureWithTimeout() throws InterruptedException, ExecutionException, TimeoutException {
        Future<Integer> future = tbt.calculate(3);
        assertEquals(new Integer(9), future.get(1500, TimeUnit.MILLISECONDS));
    }

    @Test(expected = TimeoutException.class)
    public void testGetBeforeFutureDone() throws InterruptedException, ExecutionException, TimeoutException {
        Future<Integer> future = tbt.calculate(10);
        future.get(500, TimeUnit.MILLISECONDS);
    }

    @Test(expected = CancellationException.class)
    public void testCancelFuture() throws ExecutionException, InterruptedException {
        Future<Integer> future = tbt.calculate(4);
        future.cancel(true);
        assertTrue(future.isCancelled());
        future.get();
    }

}
