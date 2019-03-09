package github.incodelearning.design_pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * Run the two tests separately to see the difference.
 */
public class EnumLazySingletonTest {
    class Wrapper {
        EnumLazySingleton tbt;
    }

    class ColorWrapper {
        Color color;
    }

    enum Color {
        MAGENTA(0xFF00FF),
        GREEN(0x008000),
        RED(0xFF0000);

        int hexCode;

        Color(int hexCode) {
            System.out.println("constructing color enum with hex code: " + hexCode);
            this.hexCode = hexCode;
        }
    }

    class WrapperDefaultNonNull {
        EnumLazySingleton tbt = EnumLazySingleton.INSTANCE;

        public WrapperDefaultNonNull() {
            System.out.println("Constructing Wrapper with enum instantiated with default value, accessing singleton.");
        }
    }

    @Test
    public void testEnumSingleton() {
        Wrapper wrapper1 = new Wrapper();
        Wrapper wrapper2 = new Wrapper();
        Assert.assertNotEquals(wrapper1.hashCode(), wrapper2.hashCode());

        Assert.assertNull(wrapper1.tbt);
        System.out.println("Singleton not constructed yet. Enum compiled and loaded into JVM.");
        wrapper1.tbt = EnumLazySingleton.INSTANCE;
        System.out.println("Singleton constructed when enum is accessed.");

        Assert.assertNull(wrapper2.tbt);
        System.out.println("Singleton already constructed and only constructed once.");
        wrapper2.tbt = EnumLazySingleton.INSTANCE;
        Assert.assertEquals(wrapper1.tbt.getSingleton().hashCode(), wrapper2.tbt.getSingleton().hashCode());
    }

    @Test
    public void testEnumSingleton2() {
        WrapperDefaultNonNull wrapper = new WrapperDefaultNonNull();
        Assert.assertNotNull(wrapper.tbt);
    }

    @Test
    public void testEnumTiming() {
        ColorWrapper wrapper = new ColorWrapper();
        System.out.println(wrapper.color);
        wrapper.color = Color.RED;
        System.out.println(wrapper.color);
    }
}
