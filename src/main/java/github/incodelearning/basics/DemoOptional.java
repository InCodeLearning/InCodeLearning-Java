package github.incodelearning.basics;

import java.util.Optional;

/**
 * https://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
 * https://www.mkyong.com/java8/java-8-optional-in-depth/
 */
public class DemoOptional {
    public static final String UNKNOWN = "unknown";
    /** Computer may or may not have a sound card */
    public class Computer {
        public Optional<SoundCard> soundCard;
        public Computer(SoundCard soundCard) {
            this.soundCard = Optional.ofNullable(soundCard);
        }
        public Optional<SoundCard> getSoundCard(){
            return soundCard;
        }
    }
    /** Sound card may or may not have a usb port */
    public class SoundCard {
        public Optional<USB> usb;
        public SoundCard(USB usb) {
            this.usb = Optional.ofNullable(usb);
        }
        public SoundCard() {
            this.usb = Optional.empty();
        }
        public Optional<USB> getUsb() {
            return usb;
        }
    }
    /** usb port may or may not have a version */
    public class USB {
        public Optional<String> version;
        public USB (String version) {
            this.version = Optional.ofNullable(version);
        }
        public Optional<String> getVersion() {
            return version;
        }

        @Override
        public String toString() {
            return String.format("USB[Version:%s]", version.orElse(UNKNOWN));
        }
    }
}
