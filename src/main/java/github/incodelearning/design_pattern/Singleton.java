package github.incodelearning.design_pattern;

/**
 * <p>Singleton pattern restricts instantiation of a class to be exactly only one instance in JVM.
 * Singleton pattern is used for logging, drivers objects, caching and thread pool. Sometimes it's appropriate
 * to have exactly one instance of a class: window managers, print spoolers, and filesystems are prototypical examples.
 * Singletons are accessed by disparate objects throughout a software system,
 * and therefore require a global point of access.
 * <p>TODO: other methods to create a singleton.
 *
 * @author Zexi Jesse Zhuang
 */
public class Singleton {

    //Singleton should only be constructed once from inside.
    private Singleton() {
        System.out.println("Singleton: private constructor accessed.");
    }

    /**
     * <p>Prior to Java 5 other methods may fail in certain scenarios where too many threads try to get the singleton
     * instance simultaneously due to memory model issues. Only when {@link #getInstance()} is called, the nested
     * static class gets loaded and creates the singleton instance.
     * <p>Because only a private constructor is available. Java compiler {@code javac} plays a trick to add a new non-private
     * (default-protected) constructor which only it knows about. That constructor takes an unused instance of an
     * anonymous class {@code Singleton$1.class} which nobody knows exists. Use {@code javap -c Singleton.class} and
     * {@code javap -c Singleton$1.class} to see the code.
     * <p>Bill Pugh singleton private static final is lazy init. Constructed
     */
    private static class BillPughSingleton {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        System.out.println("Constructing Bill Pugh Singleton...");
        return BillPughSingleton.INSTANCE;
    }

}
