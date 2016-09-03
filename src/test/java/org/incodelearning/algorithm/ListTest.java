package org.incodelearning.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

// Todo: difference between org.junit.Assert.assertEquals and this?

/**
 * @author Zexi Jesse Zhuang
 */
public class ListTest {

    /**
     * {@code remove(int index)} and {@code remove(Object o)} are different methods. When passed with an Integer,
     * the second method is called. This could be a trap if you intended to remove integer 1 from the list but
     * actually you removed the element at index 1.
     */
    @Test
    public void removeIndexOrObjectTest() {
        Integer[] nums = {5, 6, 7, 8, 9, 1};
        // note actual implementations are different for the two lists
        List<Integer> list1 = new ArrayList<>(Arrays.asList(nums));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(nums));
        list1.remove(1);
        list2.remove(new Integer(6));
        assertEquals("1th element 6 was removed from both lists", list1, list2);
        list1.remove(new Integer(1));
        list2.remove(4);
        assertEquals("4th element 1 was removed from both lists", list1, list2);
    }

}
