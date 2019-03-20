package github.incodelearning.design_pattern;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EnumSingleton3Test {
    class Wrapper {
        EnumSingleton3 tbt;
    }

    @Test
    public void testEnumSingleton() {
        Wrapper wrapper = new Wrapper();
        assertNull(wrapper.tbt);
        System.out.println("Singleton not constructed yet. Enum compiled and loaded into JVM.");
        wrapper.tbt = EnumSingleton3.INSTANCE;
        System.out.println("Singleton constructed when enum is accessed.");
        assertNotNull(wrapper.tbt.getSingleton());
    }
}
