package github.incodelearning.design_pattern;

/**
 * Singleton constructed when enum first time accessed at runtime.
 * When enum class is initialized.
 * Not the time when JVM loads the enum class definition.
 */
public enum EnumLazySingleton {
    INSTANCE;

    private final Singleton singleton;

    EnumLazySingleton() {
        System.out.println("Constructing EnumLazySingleton INSTANCE.");
        singleton = Singleton.getInstance();
    }

    public Singleton getSingleton() {
        return singleton;
    }
}
