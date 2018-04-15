package github.incodelearning.concurrency.oracle;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.FutureTask;

public class DemoCallableTest {

    DemoCallable.BasicExample basicExample;

    @Before
    public void initialize() {
        basicExample = new DemoCallable.BasicExample();
        System.out.println("initialized Callable  " + basicExample);
    }

    @Test
    public void testCallableResultInRange() throws Exception {
        // a FutureTask implements RunnableFuture, which extends Runnable and Future
        FutureTask<Integer> randomNumberTask = new FutureTask<>(basicExample);
        Thread t = new Thread(randomNumberTask);
        t.start();
        Integer result = randomNumberTask.get();
        Assert.assertTrue(result < 5 && result >= 0);
    }

    @Test
    public void testCallableSleepTimeInRange() throws Exception {
        FutureTask<Integer> randomNumberTask = new FutureTask<>(basicExample);
        long startIime = System.currentTimeMillis();
        Thread t = new Thread(randomNumberTask);
        t.start();
        Integer result = randomNumberTask.get();
        System.out.println("result " + result);
        long endTime = System.currentTimeMillis();
        double time = (endTime - startIime) / 1000d;
        System.out.println("time " + time);
        Assert.assertTrue(time >= 0L && time < 5L);
    }
}
