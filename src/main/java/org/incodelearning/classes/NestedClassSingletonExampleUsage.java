package org.incodelearning.classes;


/**
 * Created by Huilin on 8/22/16.
 * This class uses NestedClassSingletonExample.
 * In the first part, it checks only one instance of NestedClassSingletonExample is created.
 * In the second part, it shows how to instantiate and use the inner class (nonstatic and static).
 *
 **/
public class NestedClassSingletonExampleUsage {
    // This class uses NestedClassSingletonExample

    public static void main(String[] args) {


        NestedClassSingletonExample instance1 = null, instance2 = null;

        // Call the getInstance() of outer class to create an instance of outer class.
        instance1 = NestedClassSingletonExample.getInstance();
        instance2 = NestedClassSingletonExample.getInstance();
        // Check whether instance1 and instance2 are identical.
        System.out.println("Only one instance of outer class is created: " + Boolean.toString(instance1 == instance2));
        System.out.println();

        System.out.println("Initial attributes values of outclass.");
        System.out.println("outerIntegerNonStatic: " + instance1.outerIntegerNonStatic);
        System.out.println("outerStringStatic: " + NestedClassSingletonExample.outerStringStatic);
        System.out.println();

        // Construct StaticNestedClass
        NestedClassSingletonExample.StaticNestedClass staticNestedClass = new NestedClassSingletonExample.StaticNestedClass("Hi");
        System.out.println("After construct StaticNestedClass attributes values of outclass.");
        System.out.println("outerIntegerNonStatic: " + instance1.outerIntegerNonStatic + " Expected: 10");
        System.out.println("outerStringStatic: " + NestedClassSingletonExample.outerStringStatic  + " Expected: Hi");
        System.out.println("initial 0 staticClassStaticInt: " + NestedClassSingletonExample.StaticNestedClass.staticClassStaticInt);
        NestedClassSingletonExample.StaticNestedClass.test("Hello", 15);
        System.out.println("changed to 1 staticClassStaticInt: " + NestedClassSingletonExample.StaticNestedClass.staticClassStaticInt);
        System.out.println();

        // Construct NonStaticNestedClass
        NestedClassSingletonExample.NonStaticNestedClass nonStaticNestedClass =
                NestedClassSingletonExample.getInstance().new NonStaticNestedClass("Good");
        System.out.println("After construct StaticNestedClass attributes values of outclass.");
        System.out.println("outerIntegerNonStatic: " + instance1.outerIntegerNonStatic + " Expected: 15");
        System.out.println("outerStringStatic: " + NestedClassSingletonExample.outerStringStatic + " Expected: Good");
        System.out.println();

        // call test() of NonStaticNestedClass
        nonStaticNestedClass.test("GoodBye", 20);
        System.out.println("After construct StaticNestedClass attributes values of outclass.");
        System.out.println("outerIntegerNonStatic: " + instance1.outerIntegerNonStatic + " Expected: 20");
        System.out.println("outerStringStatic: " + NestedClassSingletonExample.outerStringStatic + " Expected: GoodByte");
        System.out.println();

        // Construct another StaticNestedClass
        NestedClassSingletonExample.StaticNestedClass staticNestedClass2 = new NestedClassSingletonExample.StaticNestedClass("Hi");
        System.out.println("staticNestedClass == staticNestedClass2: " + Boolean.toString(staticNestedClass == staticNestedClass2));
        NestedClassSingletonExample.StaticNestedClass.test("Hello", 25);
        System.out.println("changed to 2 staticClassStaticInt: " + NestedClassSingletonExample.StaticNestedClass.staticClassStaticInt);

        System.out.println();
    }
}
