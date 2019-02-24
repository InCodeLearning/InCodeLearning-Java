package github.incodelearning.concurrency;

import java.util.Random;

// https://stackoverflow.com/questions/16249687/java-threadlocal-static
public class ThreadLocalStringTest {

    class A {
        public void setSecret(String secret) {
            ThreadLocalString.setString(secret);
        }
    }

    class B {
        public String getSecret() {
            return ThreadLocalString.getString();
        }
    }

    class AccessSecretFromDifferentClasses implements Runnable {

        private String id; // simulate thread id secret
        private A a;
        private B b;

        public AccessSecretFromDifferentClasses(String id) {
            System.out.println(this + " constructed with id: " + id);
            this.id = id;
            this.a = new A();
            this.b = new B();
        }

        public void closeSecret() {
            ThreadLocalString.removeString();
        }

        @Override
        public void run() {
            a.setSecret(id);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this + "'s secret id: " + b.getSecret());
            closeSecret();// must clear up, thread pool reuses thread
        }
    }

    public static void main(String[] args) {
        ThreadLocalStringTest test = new ThreadLocalStringTest();
        Random random = new Random();
        AccessSecretFromDifferentClasses[] threads = new AccessSecretFromDifferentClasses[3];
        for (int i = 0; i < 3; i++) {
            String id = String.valueOf(random.nextInt(100));
            threads[i] = test.new AccessSecretFromDifferentClasses(id);
            Thread t = new Thread(threads[i]);
            t.start();
        }
    }
}
