package github.incodelearning.functional;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

import static github.incodelearning.functional.DemoStreamOpsTest.BlogPostType.*;
import static java.util.stream.Collectors.*;
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
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    class Tuple {
        BlogPostType type;
        String author;
    }

    private List<BlogPost> posts;

    private void setupBlogPosts() {
        BlogPost[] blogPosts = new BlogPost[]{
                new BlogPost("First Blog", "GongZi", NEWS, 10),
                new BlogPost("Honda Pilot Review", "GongZi", REVIEW, 20),
                new BlogPost("Java Stream Guide", "SDE-9922", GUIDE, 10),
                new BlogPost("8th Floor Cafe Review", "SDE-9922", REVIEW, 10),
                new BlogPost("Basketball Jordan", "GongZi", REVIEW, 20),
                new BlogPost("Huckleberry Review", "Derek", REVIEW, 100),
        };
        posts = Arrays.asList(blogPosts);
    }

    @Test
    public void testGroupingBy() {
        setupBlogPosts();
        // tbt.groupBy(Arrays.asList(blogPosts), BlogPost::getAuthor);
        Map<String, List<BlogPost>> postsByAuthor = tbt.groupBy(posts, post -> post.author);
        System.out.println(postsByAuthor);
        Map<String, List<BlogPost>> expected = new HashMap<>();
        for (BlogPost post : posts) {
            String author = post.getAuthor();
            if (expected.containsKey(author)) expected.get(author).add(post);
            else expected.put(author, Lists.newArrayList(post));
        }
        assertEquals(expected, postsByAuthor);
    }

    @Test
    public void testGroupingByComplexType() {
        setupBlogPosts();
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
        System.out.println(postsPerTypeAndAuthor);
    }

    @Test
    public void testGroupingByModifyReturnType(){
        setupBlogPosts();
        Map<BlogPostType, Set<BlogPost>> postsPerType = posts.stream().collect(groupingBy(BlogPost::getType, toSet()));
        System.out.println(postsPerType);
        EnumMap<BlogPostType, List<BlogPost>> postsByType = posts.stream().collect(groupingBy(BlogPost::getType,
                        () -> new EnumMap<>(BlogPostType.class), toList()));
        System.out.println(postsByType);
    }

    @Test
    public void testGroupingByThenGroupingBy() {
        setupBlogPosts();
        Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream()
                .collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));
        System.out.println(map);
    }

    @Test
    public void testGroupingByAvgOrStat() {
        setupBlogPosts();
        Map<BlogPostType, Double> averageLikesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));
        System.out.println(averageLikesPerType);
        Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, summarizingInt(BlogPost::getLikes)));
        System.out.println(likeStatisticsPerType);
    }

    @Test
    public void testConcurrentGroupingBy() {
        ConcurrentMap<BlogPostType, List<BlogPost>> postsPerType = posts.parallelStream()
                .collect(groupingByConcurrent(BlogPost::getType));
    }
}
