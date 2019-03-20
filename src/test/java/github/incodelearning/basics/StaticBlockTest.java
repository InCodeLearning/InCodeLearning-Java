package github.incodelearning.basics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class StaticBlockTest {
    class Wrapper {
        StaticBlock tbt;
    }

    @Test
    public void testStaticBlockTiming() {
        Wrapper wrapper = new Wrapper();
        System.out.println("StaticBlock class compiled and loaded into JVM.");
        assertNotNull(wrapper);
        assertNull(wrapper.tbt);
        wrapper.tbt = new StaticBlock();
        System.out.println("static block executed when instance of class constructed.");
        assertEquals("test", wrapper.tbt.getName());
    }

    @Test
    public void testStaticBlockTiming2() {
        Wrapper wrapper = new Wrapper();
        System.out.println("StaticBlock class compiled and loaded into JVM.");
        assertNotNull(wrapper);
        assertNull(wrapper.tbt);
        assertEquals("test", StaticBlock.getClassStaticName());
        System.out.println("static block executed when static method executed.");
    }

    @Test
    public void testStaticBlockTiming3() {
        Wrapper wrapper = new Wrapper();
        System.out.println("StaticBlock class compiled and loaded into JVM.");
        assertNotNull(wrapper);
        assertNull(wrapper.tbt);
        assertEquals("random", StaticBlock.getRandomString());
        System.out.println("static block executed when any static method executed.");
    }

    @Test
    public void testStaticBlockTiming4() throws ClassNotFoundException {
        Wrapper wrapper = new Wrapper();
        System.out.println("StaticBlock class compiled but not loaded by the vm.");
        assertNotNull(wrapper);
        assertNull(wrapper.tbt);
        //force jvm to load the StaticBlock class
        assertEquals(Class.forName("github.incodelearning.basics.StaticBlock"), StaticBlock.class);
    }
}
