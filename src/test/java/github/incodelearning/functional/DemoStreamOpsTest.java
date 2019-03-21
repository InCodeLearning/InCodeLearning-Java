package github.incodelearning.functional;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static github.incodelearning.functional.DemoStreamOpsTest.BlogPostType.*;
import static org.junit.Assert.assertEquals;

public class DemoStreamOpsTest {
    private DemoStreamOps tbt;

    @Before
    public void setup() {
        tbt = new DemoStreamOps();
    }

    @Test
    public void testArrayToList() {
        Integer[] integers = new Integer[]{1, 2, 3};
        List<Integer> integerList = Arrays.asList(integers);
        assertEquals(integerList, tbt.arrayToList(integers));
    }

    @Test
    public void testArrayToMutableList() {
        Integer[] integers = new Integer[]{1, 2, 3};
        List<Integer> integerList = tbt.arrayToList(integers);
        integerList.add(4);
        assertEquals(4, integerList.size());
        System.out.println(integerList);
    }

    @AllArgsConstructor
    @Getter
    @ToString
    class BlogPost {
        String title;
        String author;
        BlogPostType type;
        int likes;
    }

    enum BlogPostType {
        NEWS,
        REVIEW,
        GUIDE
    }

    /**
     * Group posts by the combination of their type and author attributes.
     */
    class Tuple {
        BlogPostType type;
        String author;
    }

    @Test
    public void testGroupingBy() {
        BlogPost[] blogPosts = new BlogPost[]{
                new BlogPost("First Blog", "GongZi", NEWS, 10),
                new BlogPost("Honda Pilot Review", "GongZi", REVIEW, 20),
                new BlogPost("Java Stream Guide", "SDE-9922", GUIDE, 10),
        };
        // tbt.groupBy(Arrays.asList(blogPosts), BlogPost::getAuthor);
        Map<String, List<BlogPost>> postsByAuthor = tbt.groupBy(Arrays.asList(blogPosts), post -> post.author);
        System.out.println(postsByAuthor);
        Map<String, List<BlogPost>> expected = new HashMap<>();
        for (BlogPost post : blogPosts) {
            String author = post.getAuthor();
            if (expected.containsKey(author)) expected.get(author).add(post);
            else expected.put(author, Lists.newArrayList(post));
        }
        assertEquals(expected, postsByAuthor);
    }
}
