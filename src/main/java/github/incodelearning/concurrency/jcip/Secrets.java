package github.incodelearning.concurrency.jcip;

import java.util.HashSet;
import java.util.Set;

/**
 * publishing an object.
 */
public class Secrets {
    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<Secret>();
    }
}


class Secret {
}