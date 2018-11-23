package github.incodelearning.concurrency.oracle;

public class DemoThread {

    public static void twoThreadsRacing() throws InterruptedException {
        Thread thread2 = new Thread(() -> System.out.println("Hello from new thread"));
        thread2.start();
        Thread.yield(); // let scheduler know the thread is willing to wait
        System.out.println("Hello from main thread");
        thread2.join(); // waits for thread2 to terminate, when run() returns
        System.out.println("----------------------");
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++) twoThreadsRacing();
//        twoThreadsRacing();
    }

}
