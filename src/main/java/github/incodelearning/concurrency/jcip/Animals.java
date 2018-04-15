package github.incodelearning.concurrency.jcip;

import java.util.*;

/**
 * <p>Thread confinement, not to share mutable data. Swing uses thread confinement extensively. The swing visual
 * components and data objects are not thread safe. Safety is achived by confining them to Swing event dispatch
 * thread. Swing provides a invokeLater mechanism to schedule a Runnable for execution in the event thread. Another
 * common application is the use of pooled JDBC Connection objects.
 * <ul>
 *     <li>Ad-hoc thread confinement. Responsibility falls entirely on implementation. The decision to use thread
 *     confinement is often a consequence of decision to implement a sub system, such as GUI, as a single threaded
 *     system, which offers deadlock avoidance and simplicity benefit that outweighs the fragility of
 *     ad-hoc thread confinement.</li>
 *     <li>Stack confinement. Object can only be reached through local variables, which exists on the executing
 *     thread's stack. Primitive local variables (e.g., numPairs below) are always stack confined.</li>
 *     <li>ThreadLocal.</li>
 *     <li></li>
 * </ul>
 */
public class Animals {
    Ark ark;
    Species species;
    Gender gender;

    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        // animals confined to method, don't let them escape!
        animals = new TreeSet<Animal>(new SpeciesGenderComparator());
        animals.addAll(candidates);
        for (Animal a : animals) {
            if (candidate == null || !candidate.isPotentialMate(a))
                candidate = a;
            else {
                ark.load(new AnimalPair(candidate, a));
                ++numPairs;
                candidate = null;
            }
        }
        return numPairs;
    }


    class Animal {
        Species species;
        Gender gender;

        public boolean isPotentialMate(Animal other) {
            return species == other.species && gender != other.gender;
        }
    }

    enum Species {
        AARDVARK, BENGAL_TIGER, CARIBOU, DINGO, ELEPHANT, FROG, GNU, HYENA,
        IGUANA, JAGUAR, KIWI, LEOPARD, MASTADON, NEWT, OCTOPUS,
        PIRANHA, QUETZAL, RHINOCEROS, SALAMANDER, THREE_TOED_SLOTH,
        UNICORN, VIPER, WEREWOLF, XANTHUS_HUMMINBIRD, YAK, ZEBRA
    }

    enum Gender {
        MALE, FEMALE
    }

    class AnimalPair {
        private final Animal one, two;

        public AnimalPair(Animal one, Animal two) {
            this.one = one;
            this.two = two;
        }
    }

    class SpeciesGenderComparator implements Comparator<Animal> {
        public int compare(Animal one, Animal two) {
            int speciesCompare = one.species.compareTo(two.species);
            return (speciesCompare != 0)
                    ? speciesCompare
                    : one.gender.compareTo(two.gender);
        }
    }

    class Ark {
        private final Set<AnimalPair> loadedAnimals = new HashSet<AnimalPair>();

        public void load(AnimalPair pair) {
            loadedAnimals.add(pair);
        }
    }

    public static void main(String[] args) {
        for(Gender gender : Gender.values()) {
            System.out.println(gender.name());
        }
    }
}
