package github.incodelearning.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hashmap related knowledge points.
 *
 * @author Zexi Jesse Zhuang
 */
public class DemoHashMap {

    /**
     * dict non hashable in python. HashMap hashable in Java.
     */
    public static void mapAsKey() {
        String[][] flightRoutes = {{"Seattle", "LA", "NY"}, {"SF", "NY", "DC"}, {"SF", "Seattle", "DC"},
                {"NY", "DC", "Seattle"}, {"LA", "SF", "DC"}};
        HashMap<String, List<Integer>> routeNumbers = new HashMap<>();
        HashMap<HashMap<String, List<Integer>>, Integer> routeCount = new HashMap<>();
        for (int routeNumber = 0; routeNumber < flightRoutes.length; routeNumber++) {
            for (int stop = 0; stop < flightRoutes[routeNumber].length; stop++)
                routeNumbers.computeIfAbsent(
                        flightRoutes[routeNumber][stop], k -> new ArrayList<Integer>()
                ).add(routeNumber);
        }
        routeCount.put(routeNumbers, flightRoutes.length);
        System.out.println(routeNumbers);
        System.out.println(routeCount);
    }

    /**
     * Allows mutable types as keys but not recommended by CharSequence interface, which StringBuilder implements.
     */
    public static void mutableKey() {
        StringBuilder[] presidents = {new StringBuilder("Bill clinton"), new StringBuilder("Barack Obama")};
        String[] times = {"1993-2001", "2008-2016"};
        HashMap<StringBuilder, String> presidentTimes = new HashMap<>();
        for (int i = 0; i < times.length; i++)
            presidentTimes.put(presidents[i], times[i]);
        System.out.println(presidentTimes);
        presidents[0].setCharAt(5, 'C');
        System.out.println(presidentTimes);
    }

    public static void main(String[] args) {
        mutableKey();
        mapAsKey();
    }
}
