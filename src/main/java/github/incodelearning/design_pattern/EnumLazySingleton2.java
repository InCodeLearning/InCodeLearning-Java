package github.incodelearning.design_pattern;

public enum EnumLazySingleton2 {
    INSTANCE;

    private final Singleton singleton = Singleton.getInstance();

    public Singleton getSingleton() {
        return singleton;
    }
}
