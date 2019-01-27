package github.incodelearning.concurrency;

import java.util.Random;

public class Philosopher extends Thread {
    private Integer leftChopstick, rightChopstick;
    private Random random;

    public Philosopher(Integer leftChopstick, Integer rightChopstick) {
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.random = new Random();
    }

    /**
     * To avoid deadlock, one philosopher grab right first. Assuming chopsticks are numbered.
     * @param leftChopstick
     * @param rightChopstick
     * @return a Philosopher
     */
    public Philosopher grabChopstick (Integer leftChopstick, Integer rightChopstick) {
        if (leftChopstick < rightChopstick) return new Philosopher(leftChopstick, rightChopstick);
        else return new Philosopher(rightChopstick, leftChopstick);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000)); // Think for a while
                synchronized (leftChopstick) {
                    synchronized (rightChopstick) {
                        Thread.sleep(random.nextInt(1000)); // eat for a while
                    }
                }
            }
        } catch (InterruptedException e) {}
    }

}
