package github.incodelearning.concurrency.jcip;

/**
 * The reader thread could loop forever, print zero, or 42.
 * <p>
 * There is no guarantee operations in one thread will be performed in the order given by the program,
 * as long as reordering is not detectable from within that thread - even
 * if reordering is apparent to other threads. It's meant to allow JVMs to take full advantage of the performance
 * of modern multiprocessor hardware. In absence of synchronization, the java memory model permits the compiler to
 * reorder operations and cache values in registers, and permits CPU to reorder operations and cache values in
 * processor-specific caches.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
