package github.incodelearning.concurrency.forkjoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

public class FactorialSquareCalculatorTest {
    private static final int num = 1000;

    @Test
    public void testForkJoin() {
        testTask(this::forkJoin, "forkJoin", num);
    }

    @Test
    public void testRecursive() {
        testTask(this::recursive, "recursive", num); // input 10,000 stack overflow
    }

    @Test
    public void testIterative() {
        testTask(this::iterative, "iterative", num);
    }

    private void testTask(Function<Integer, Long> function, String functionName, int input) {
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long result = function.apply(input);
            long time = System.nanoTime() - start;
            System.out.println(functionName + " result: " + result);
            System.out.println(functionName + " time: " + time);
        }
    }

    private long iterative(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) result += i * i;
        return result;
    }

    private long recursive(int n) {
        if (n == 1) return 1;
        return n * n + recursive(n - 1);
    }

    private long forkJoin(int n) {
        try {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            FactorialSquareCalculator calculator = new FactorialSquareCalculator(n);
            forkJoinPool.execute(calculator);
            return calculator.get();
        } catch (Exception e) {
            return -1;
        }
    }
}
