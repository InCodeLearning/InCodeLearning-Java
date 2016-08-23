package org.incodelearning.nestedclass;

/**
 * Created by Huilin on 8/22/16.
 *
 * This class demonstrates nested classes.
 * Also shows the use of nested class to implement the singleton pattern as an example.
 *  Singleton pattern means only one instance of this class can be created.
 *
 *  Ref: nested class: http://www.tutorialspoint.com/java/java_innerclasses.htm
 *       singleton: http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 *
 * There are two types of nested classes: static and nonstatic
 * static nested class is associated with the outside class (like a static method)
 * nonstatic nested class is associated with an object of the outside class (like a nonstatic method).
 * For nonstatic nested class, there are (1) inner classes (scope is in class),
 * (2) method local inner classes (defined in a method, can only be accessed inside the method),
 * (3) anonymous inner class (I will work on this next week).
 */


public class NestedClassSingletonExample {

    public int outerIntegerNonStatic = 10;
    public static String outerStringStatic = "Hello";

    // 1. make the constructor private, cannot be accessed from outside.
    private NestedClassSingletonExample(){
    }

    // 2. write a nested class SingletonHelpler, which maintains an static field that is an instance of NestedClassSingletonExample.
    //    also have the nested class as private (cannot be accessed from outside).

    // Note: This nested class is declared as static. Only inner class can be declared as static (outer class cannot).
    // Non-static nested class can access both static and non-static members of Outer class.
    // Non-static nested class can only be instantiated with an instance of outer class (like a non-static method).
    // A static class can access only static members of Outer class.
    // A static class can be instantiated with the Outer Class name (like a static method).
    private static class SingletonHelper{

        // 3. have the variable INSTANCE as static which ensures INSTANCE only created once (created when the inner class is loaded)
        // Note: if we do not have the inner class, but instead, have the following code line directly in the outside class,
        // INSTANCE would be created whenever the outside class is loaded to JVM (even though we do not need an
        // instance the outer class, such as in case we only want to access a static method of the outer class), this is not efficient.
        // With an inner class, an instance of the outclass is created only necessary (when getInstance() below is called).
        private static final NestedClassSingletonExample INSTANCE = new NestedClassSingletonExample();
    }

    // 4. public getter to get the instance.
    public static NestedClassSingletonExample getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public static void staticMethod() {
        System.out.println("A static method of outer class is called.");
    }

    // ****************************************************************** //
    // Below is demonstrating more nested class, not related with singleton.
    public static class StaticNestedClass {

        public static int staticClassStaticInt = 0;

        // for static nested class, only static field in the outter class can be accessed. (outerIntegerNonStatic cannot be accessed)
        public StaticNestedClass(String innerString) {
            outerStringStatic = innerString;
        }
        // can be declared as static or not.
        public static void test(String innerString, int i) {
            outerStringStatic = innerString;
            getInstance().outerIntegerNonStatic = i;
            staticClassStaticInt++;
        }
    }

    public class NonStaticNestedClass {
        // for non static nested class, all fields in the outter class can be accessed.
        public NonStaticNestedClass(String innerString) {
            outerStringStatic = innerString;
        }
        // cannot be declared as static
        public void test(String innerString, int i) {
            outerStringStatic = innerString;
            outerIntegerNonStatic = i;
        }
    }

}
