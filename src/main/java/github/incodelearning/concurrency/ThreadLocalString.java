package github.incodelearning.concurrency;

public class ThreadLocalString {
    private static final ThreadLocal<String> string = new ThreadLocal<>();

    public static void setString(String secret) {
        System.out.println(string + " setting secret to " + secret);
        string.set(secret);
    }

    public static String getString() {
        return string.get();
    }

    public static void removeString() {
        string.remove();
    }

}
