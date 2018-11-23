package github.incodelearning.concurrency;

/**
 * Race condition.
 */
public class Counting {
    interface Count {
        void increment();

        int getCount();
    }

    static class Counter implements Count {
        private int count = 0;

        /**
         * byte code for {@code ++count}
         * <pre>
         * getfield #2
         * iconst_1
         * iadd
         * putfield #2
         * </pre>
         */
        public void increment() {
            ++count;
        }

        public int getCount() {
            return count;
        }
    }

    static class Counter2 implements Count {
        private int count = 0;

        public synchronized void increment() {
            ++count;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Count counter = new Counter();
        final Count counter2 = new Counter2();
        class CountingThread extends Thread {
            public void run() {
                for (int x = 0; x < 10000; ++x) {
                    counter.increment();
                    counter2.increment();
                }
            }
        }
        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
        System.out.println(counter2.getCount());
    }
}
