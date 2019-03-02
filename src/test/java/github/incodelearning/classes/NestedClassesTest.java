package github.incodelearning.classes;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NestedClassesTest {
    private static NestedClasses tbt1;
    private static NestedClasses.PublicStaticNestedClass tbt2;
    private static NestedClasses.PackageDefaultNestedClass tbt3;

    @BeforeClass
    public static void setup() {
        tbt1 = new NestedClasses();
        tbt2 = new NestedClasses.PublicStaticNestedClass();
        tbt3 = tbt1.new PackageDefaultNestedClass();
    }

    @Test
    public void testOuterStatic() {
        assertEquals("Hello", NestedClasses.outerStaticString);
        assertEquals("Hello", tbt1.outerStaticString);
        String newValue = "newValue";
        tbt2.setOuterStaticString(newValue);
        assertEquals(newValue, NestedClasses.outerStaticString);
        assertEquals(newValue, tbt1.outerStaticString);
        tbt3.setOuterNonStaticInt(13);
        assertEquals(13, tbt1.outerNonStaticInt);
    }

    @Test
    public void testOuterNonStatic() {
        assertEquals(10, tbt1.outerNonStaticInt);
    }
}
