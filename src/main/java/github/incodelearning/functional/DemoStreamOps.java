package github.incodelearning.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Tricks on streams.
 */
public class DemoStreamOps {
    public <E> List<E> arrayToList(E[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public <E> Map<String, List<E>> groupBy(List<E> list, Function<E, String> getter) {
        return list.stream().collect(groupingBy(getter));
    }
}
