package github.incodelearning.design_pattern;

public enum EnumSingleton {
    INSTANCE;

    private final Singleton singleton;

    EnumSingleton() {
        singleton = Singleton.getInstance();
    }

    public Singleton getSingleton() {
        return singleton;
    }
}
