package github.incodelearning.basics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class DemoOptionalTest {

    DemoOptional tbt;

    @Before
    public void setup() {
        this.tbt = new DemoOptional();
    }

    @Test
    public void testIfPresent() {
        Optional<DemoOptional.USB> optionalUsb = Optional.of(tbt.new USB("3.0"));
        optionalUsb.ifPresent(System.out::println);
    }

    @Test
    public void testFilterMatching() {
        Optional<DemoOptional.USB> optionalUsb = Optional.ofNullable(tbt.new USB("3.0"));
        optionalUsb.filter(usb -> "3.0".equals(usb.version.orElse("unknown"))).ifPresent(System.out::println);
        List<Optional<DemoOptional.USB>> maybeUSBs = new ArrayList<>();
        maybeUSBs.add(optionalUsb);
        maybeUSBs.add(Optional.of(tbt.new USB("2.0")));
        assertEquals(1, maybeUSBs.stream().filter(usbo -> usbo.filter(
                usb -> "3.0".equals(usb.version.orElse("unknown"))).isPresent()).count());
    }

    @Test
    public void testFilterNonMatching() {
        Optional<DemoOptional.USB> maybeUSB = Optional.ofNullable(null);
        assertEquals(Optional.empty(), maybeUSB.filter(usb -> "3.0".equals(usb.version.orElse("unknown"))));
        maybeUSB = Optional.ofNullable(tbt.new USB("2.0"));
        assertEquals(Optional.empty(), maybeUSB.filter(usb -> "3.0".equals(usb.version.orElse("unknown"))));
    }

    @Test
    public void testMap() {
        Optional<DemoOptional.USB> optionalUsb = Optional.of(tbt.new USB("3.0"));
        System.out.println(optionalUsb.map(DemoOptional.USB::getVersion));//embedded/nested optional
        System.out.println(Optional.of("test").map(String::toUpperCase));
    }

    @Test
    public void testCascading() {
        DemoOptional.Computer computer = null;
        assertEquals(DemoOptional.UNKNOWN, getVersion(Optional.ofNullable(computer)));
        String version = "2.3";
        computer = tbt.new Computer(tbt.new SoundCard(tbt.new USB(version)));
        assertEquals(version, getVersion(Optional.of(computer)));
        computer = tbt.new Computer(tbt.new SoundCard(tbt.new USB(null)));
        assertEquals(DemoOptional.UNKNOWN, getVersion(Optional.ofNullable(computer)));
        computer = tbt.new Computer(tbt.new SoundCard());
        assertEquals(DemoOptional.UNKNOWN, getVersion(Optional.ofNullable(computer)));
    }

    @Test(expected = NullPointerException.class)
    public void testOptionalDefaultValue() {
        DemoOptional.SoundCard soundCard = tbt.new SoundCard();
        soundCard.getUsb().ifPresent(usb -> System.out.println(usb));
    }

    private String getVersion(Optional<DemoOptional.Computer> optionalComputer) {
        return optionalComputer.flatMap(DemoOptional.Computer::getSoundCard)
                .flatMap(DemoOptional.SoundCard::getUsb)
                .flatMap(DemoOptional.USB::getVersion).orElse(DemoOptional.UNKNOWN);
    }
}
