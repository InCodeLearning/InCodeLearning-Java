package org.incodelearning.classes;

/**
 * <p>Compelling reasons for using nested classes include the following:
 * <ul>
 * <li>Grouping helper classes only used in one place.
 * <li>Increases encapsulation.
 * <li>More readable and maintainable with code closer to where used.
 * </ul>
 * <p>There are two types of nested classes:<ul>
 * <li>static
 * <li>non-static, also called inner classes
 * <ul>two special kinds of inner classes:
 * <li>local classes
 * <li>anonymous classes, see {@link PersonLambda#main(String[]) PersonLambda.main's} first method call of
 * printPsersons with an anonymous class.
 * </ul>
 * </ul>
 * <p>As a member of the OuterClass, a nested class can be declared private, public, protected, or package private.
 * (Recall that outer classes can only be declared public or package private.)
 * <p>All fields should be private unless there is a good reason to be exposed. Similarly, all nested classes
 * should be private unless it needs to be exposed and should be static unless it needs to access outer class's
 * non-static fields and methods. Because a non static nested class's instance belong to an instance of the
 * outer class, it has an implicit reference (8 byte extra overhead) to its outer instance.
 * TODO: add shadowing and serialization from oracle java tutorial.
 *
 * @author Huilin Shi
 * @author Zexi Jesse Zhuang
 */


public class NestedClasses {

    public int outerNonStaticInt = 10;
    public static String outerStaticString = "Hello";

    public static void staticMethod() {
        System.out.println("A static method of outer class is called.");
    }

    /**
     * Only nested classes can be declared as static (regular classes cannot).  A static nested class can be
     * instantiated with the Outer Class name (like a static method). Compiles to
     * {@code NestedClasses$StaticNestedClass.class}.
     */
    private static class StaticNestedClass {

        public static int staticIntCounter = 0;
        public static int nonStaticInt = 0;

        /**
         * A static class can access only static members of outer class. This method sets the outer class's static
         * String variable to a different string.
         *
         * @param newString new value to set the outer String
         */
        public void setOuterStaticString(String newString) {
            outerStaticString = newString;
            staticMethod();
        }

        /**
         * This method can be declared as static or not. Set the outer non static integer to a new value.
         *
         * @param newInt new value to set the outer Integer
         */
        public static void setOuterNonStaticInt(int newInt) {
            new NestedClasses().outerNonStaticInt = newInt;
        }


    }

    /**
     * Non-static nested class can access both static and non-static members of Outer class and can only be
     * instantiated with an instance of outer class (like a non-static method). Because an inner class is associated
     * with an instance, it cannot define any static members itself. Compiles to
     * {@code NestedClasses$NonStaticNestedClass.class}.
     */
    private class NonStaticNestedClass {

        public int nonStaticInt;

        // cannot be declared as static
        public void setOuterStaticString(String newString) {
            outerStaticString = newString;
        }

        public void setOuterNonStaticInt(int newInt) {
            outerNonStaticInt = newInt;
        }
    }

    public static void main(String[] args){
        //TODO: tests
    }
}
