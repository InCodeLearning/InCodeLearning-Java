package github.incodelearning.concurrency;

/**
 * We might even see "The meaning of life is: 0". https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html#jls-17.4
 * <p>
 * <ul>
 * <li>The compiler is allowed to statically optimize your code by reordering things.
 * <li> The JVM is allowed to dynamically optimize your code by reordering things.
 * <li> The hardware you’re running on is allowed to optimize performance by reordering things.
 * </ul>
 */
public class Puzzle {
    static boolean answerReady = false;
    static int answer = 0;
    static Thread t1 = new Thread(() -> {
        answer = 42;
        answerReady = true;
    });

    static Thread t2 = new Thread(() -> {
        if (answerReady) System.out.println("The meaning of life is: " + answer);
        else System.out.println("I don't know the answer");
    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

