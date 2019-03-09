package github.incodelearning.collections;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapTest {
    @Test(expected = UnsupportedOperationException.class)
    public void testCollectionsEmptyMapIsImmutable() {
        Map<String, String> map = Collections.EMPTY_MAP;
        map.put("k", "v");
    }

    @Test
    public void testFinalMapMutable() {
        Map<String, Map<String, String>> nestedMap = new HashMap<>();
        Nested nested = new Nested();
        nestedMap.put("test", nested.getMap());
        String key = "k", value = "v";
        System.out.println(nested.getMap());
        System.out.println(nestedMap);
        nested.getMap().put(key, value);
        assertEquals(value, nested.getMap().get(key));
        System.out.println(nested.getMap());
        System.out.println(nestedMap);
        assertEquals(value, nestedMap.get("test").get(key));
    }

    class Nested {
        private final Map<String, String> map;
        Nested(){
            map = new HashMap<>();
        }
        Map<String, String> getMap() {
            return this.map;
        }
    }
}
