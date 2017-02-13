package github.incodelearning.concurrency;

/**
 * A common idiom that uses check-then-act is Lazy Initialization.
 */
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) instance = new ExpensiveObject();
        return instance;
    }
}

class ExpensiveObject {
}
