package github.incodelearning.concurrency.forkjoin;

import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask<Long> {
    private Integer n;

    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n == 1) return 1L;
        FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);
        calculator.fork();
        return n * n + calculator.join();
    }
}
