package github.incodelearning.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <p>
 * Lambdas are created at runtime similar to a static method. Anonymous classes are created at compile time. Lambdas
 * are ore efficient used invokeddynamic instruction. See Sergey Kuksenko study at
 * http://www.oracle.com/technetwork/java/jvmls2013kuksen-2014088.pdf and stackoverflow 24294846. Slow to warm up but
 * when JIT inlines it worst case same performance as anonymous classes but can be better.
 */
public class LambdaPerson {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public static int compareByAge(LambdaPerson a, LambdaPerson b) {
		return a.birthday.compareTo(b.birthday);
	}

	public int getAge() {
		return LocalDateTime.now().getYear() - birthday.getYear();
	}

	public void printPerson() {
		// TODO: ...
	}

	// simplistic approach
	public static void printPersonsOlderThan(List<LambdaPerson> roster, int age) {
		for (LambdaPerson p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	// more generalized search methods
	public static void printPersonsWithinAgeRange(List<LambdaPerson> roster, int low,
                                                  int high) {
		for (LambdaPerson p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	// Approach 3: Specify Search Criteria Code in a Local Class
	public static void printPersons(List<LambdaPerson> roster, CheckPerson tester) {
		for (LambdaPerson p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	// Approach 6: Use Standard Functional Interfaces with Lambda Expressions
	public static void printPersonsWithPredicate(List<LambdaPerson> roster,
			Predicate<LambdaPerson> tester) {
		for (LambdaPerson p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	// Approach 7: Use Lambda Expressions Throughout Your Application
	public static void processPersons(List<LambdaPerson> roster,
                                      Predicate<LambdaPerson> tester, Consumer<LambdaPerson> block) {
		for (LambdaPerson p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	public static void processPersonsWithFunction(List<LambdaPerson> roster,
                                                  Predicate<LambdaPerson> tester, Function<LambdaPerson, String> mapper,
                                                  Consumer<String> block) {
		for (LambdaPerson p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static void main(String[] args) {
		List<LambdaPerson> roster = new ArrayList<>();
		// anonymous class, compiles to LambdaPerson$1.class.
		printPersons(roster, new CheckPerson() {
			public boolean test(LambdaPerson p) {
				return p.gender == Sex.MALE && p.getAge() >= 18
						&& p.getAge() <= 25;
			}
		});

		// Approach 5: Specify Search Criteria Code with a Lambda Expression
		printPersons(roster, (LambdaPerson p) -> p.getGender() == Sex.MALE
				&& p.getAge() >= 18 && p.getAge() <= 25);

		// notice lambda expression here is different on left of ->
		printPersonsWithPredicate(roster, p -> p.getGender() == Sex.MALE
				&& p.getAge() >= 18 && p.getAge() <= 25);

		processPersons(
				roster,
				p -> p.getGender() == Sex.MALE && p.getAge() >= 18
						&& p.getAge() <= 25, p -> p.printPerson());

		processPersonsWithFunction(
				roster,
				p -> p.getGender() == Sex.MALE && p.getAge() >= 18
						&& p.getAge() <= 25, p -> p.getEmailAddress(),
				email -> System.out.println(email));

		processElements(
				roster,
				p -> p.getGender() == Sex.MALE && p.getAge() >= 18
						&& p.getAge() <= 25, p -> p.getEmailAddress(),
				email -> System.out.println(email));

		// Approach 9: Use Aggregate Operations That Accept Lambda Expressions
		// as Parameters
		roster.stream()
				.filter(p -> p.getGender() == Sex.MALE
						&& p.getAge() >= 18 && p.getAge() <= 25)
				.map(p -> p.getEmailAddress())
				.forEach(email -> System.out.println(email));

		LambdaPerson[] rosterAsArray = roster.toArray(new LambdaPerson[roster.size()]);
		// method reference
		Arrays.sort(rosterAsArray, (a, b) -> LambdaPerson.compareByAge(a, b));
		Arrays.sort(rosterAsArray, LambdaPerson::compareByAge);

		String[] stringArray = { "Barbara", "James", "Mary", "John",
				"Patricia", "Robert", "Michael", "Linda" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		for (String string : stringArray) {
			System.out.println(string);
		}
		
		Set<LambdaPerson> rosterSetLambda =
			    transferElements(roster, () -> { return new HashSet<>(); });
		Set<LambdaPerson> rosterSet = transferElements(roster, HashSet::new);

	}

	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
			SOURCE sourceCollection, Supplier<DEST> collectionFactory) {

		DEST result = collectionFactory.get();
		for (T t : sourceCollection) {
			result.add(t);
		}
		return result;
	}

	// Approach 8: Use Generics More Extensively
	public static <X, Y> void processElements(Iterable<X> source,
			Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public Sex getGender() {
		return gender;
	}

}
