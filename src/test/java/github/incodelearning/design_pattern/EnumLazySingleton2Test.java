package github.incodelearning.design_pattern;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EnumLazySingleton2Test {
    class Wrapper {
        EnumLazySingleton2 tbt;

        public Wrapper() {
            tbt = null;
        }

        public Wrapper(EnumLazySingleton2 enumSingleton) {
            this.tbt = enumSingleton;
        }
    }

    @Test
    public void testEnumSingleton() {
        Wrapper wrapper = new Wrapper();
        Wrapper wrapper1 = new Wrapper();
        assertNull(wrapper.tbt);
        wrapper.tbt = EnumLazySingleton2.INSTANCE;
        System.out.println("Singleton constructed when enum first time accessed in runtime.");
        assertNull(wrapper1.tbt);
        wrapper1.tbt = EnumLazySingleton2.INSTANCE;
        assertEquals(wrapper.tbt.getSingleton().hashCode(), wrapper1.tbt.getSingleton().hashCode());
    }

    @Test
    public void testEnumSingleton2() {
        Wrapper wrapper = new Wrapper(EnumLazySingleton2.INSTANCE);
        assertNotNull(wrapper.tbt);
        Wrapper wrapper1 = new Wrapper(EnumLazySingleton2.INSTANCE);
        assertNotNull(wrapper1.tbt);
        Assert.assertNotEquals(wrapper1.hashCode(), wrapper.hashCode());
    }

}
