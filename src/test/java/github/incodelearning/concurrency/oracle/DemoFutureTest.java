package github.incodelearning.concurrency.oracle;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

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
        while (!future.isDone()) {
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
        assertTrue(future.isDone());
        future.get();
    }

    @Test
    public void testCancelFutureNotInterrupting() throws InterruptedException, ExecutionException {
        Future<Integer> future = tbt.sleep();
        Thread.sleep(500);
        future.cancel(false);
        assertTrue(future.isCancelled());
    }

    @Test
    public void testCancelFutureInterrupting() throws InterruptedException {
        Future<Integer> future = tbt.sleep();
        Thread.sleep(500);
        future.cancel(true);
        assertTrue(future.isCancelled());
    }

    @Test
    public void testFutureSingleThread() throws InterruptedException, ExecutionException {
        testTwoThreads(1000, 3000);
    }

    @Test
    public void testFutureTwoThreads() throws ExecutionException, InterruptedException {
        tbt = new DemoFuture().new SquareCalculator(2);
        testTwoThreads(1000, 2000);
    }

    private void testTwoThreads(int low, int high) throws InterruptedException, ExecutionException {
        Future<Integer> future1 = tbt.calculate(10);
        Future<Integer> future2 = tbt.calculate(100);
        long start = System.currentTimeMillis();
        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        long time = System.currentTimeMillis() - start;
        System.out.println("total time (s): " + time / 1000.0);
        System.out.println(result1 + " and " + result2);
        assertTrue(time > low && time < high);
    }
}
