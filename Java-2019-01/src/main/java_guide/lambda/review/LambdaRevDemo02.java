package lambda.review;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 余修文
 * @date 2019/4/4 8:38
 */
public class LambdaRevDemo02 {

    public List<String> init() {
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
        return list;
    }

    @Test
    public void demo01() {
        List<String> list = init();
        list.stream()
                .filter(s -> s.startsWith("d")).forEach(System.out::println);
    }

    @Test
    public void demo02() {
        List<String> list = init();
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void demo03() {
        List<String> list = init();
        list.stream()
                .map(s -> String.valueOf(s.charAt(s.length() - 1))).forEach(System.out::println);
    }

    @Test
    public void demo04() {
        List<String> list = init();
        Boolean isAnyMatch = list.stream().anyMatch(s -> s.contains("a"));
        System.out.println(isAnyMatch);
        Boolean isAllMatch = list.stream().allMatch(s -> s.startsWith("z"));
        System.out.println(isAllMatch);
        Boolean isNoneMatch = list.stream().noneMatch(s -> s.contains("hihi"));
        System.out.println(isNoneMatch);
    }

    @Test
    public void demo05() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        long count = list.stream().count();
        System.out.println(count);
    }

    @Test
    public void demo06() {
        List<BigDecimal> list = new ArrayList<>();
        for (int i = 0; i < 55; i++) {
            list.add(new BigDecimal(i));
        }
        Optional<BigDecimal> reduced = list.stream().reduce(BigDecimal::add);
        System.out.println(reduced.get());
    }

    public List<String> initString() {
        int max = 1000000;
        List<String> list = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            list.add(uuid.toString());
        }
        return list;
    }

    @Test
    public void demo07() {
        long t0 = System.nanoTime();
        List<String> list = initString();
        long count = list.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }
    // 3747

    @Test
    public void demo08() {
        long t0 = System.nanoTime();
        List<String> list = initString();
        long count = list.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

}
