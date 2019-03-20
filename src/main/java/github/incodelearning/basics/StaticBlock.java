package github.incodelearning.basics;

public class StaticBlock {

    private static String name;

    static {
        name = "test";
        System.out.println("static block executed in StaticBlock class.");
    }

    public String getName() {
        return name;
    }

    public static String getClassStaticName() {
        return name;
    }

    public static String getRandomString() {
        return "random";
    }
}
