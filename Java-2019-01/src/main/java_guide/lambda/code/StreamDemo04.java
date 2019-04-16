package lambda.code;

import lambda.bo.PersonBo;
import org.junit.Test;
import other.other2019_02.inherit.People;

import javax.crypto.interfaces.PBEKey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream流
 *
 * @author 余修文
 * @date 2019/4/3 16:31
 */
public class StreamDemo04 {

    /**
     * filter：筛选
     */
    @Test
    public void demo01() {
        List<String> list = new ArrayList<>();
        list.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    /**
     * sort排序
     */
    @Test
    public void demo02() {
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
        list.stream().sorted().forEach(s -> System.out.println(s));
    }

    /**
     * Map映射
     */
    @Test
    public void demo03() {
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
        list.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
    }

    /**
     * Match（匹配）：所有的匹配操作都是最终操作，并返回一个Boolean类型的值
     * anyMatch:只要其中有一个满足条件，就返回true
     * allMatch：所有的都要满足条件，才返回true
     * noneMatch：所有的都不满足就返回true
     */
    @Test
    public void demo04() {
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
        // 测试Match（匹配）操作
        boolean anyStartWithA =
                list.stream()
                .anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartWithA);
        boolean allStartWithA =
                list.stream()
                .allMatch(s -> s.startsWith("a"));
        System.out.println(allStartWithA);
        boolean noneStartWith =
                list.stream()
                .noneMatch(s -> s.startsWith("z"));
        System.out.println(noneStartWith);

    }

    /**
     * count：计数
     */
    @Test
    public void demo05() {
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
        long startWithB =
                list.stream()
                        .filter(s -> s.startsWith("b"))
                        .count();
        System.out.println(startWithB);
    }

    /**
     * Reduce（规约）
     */
    @Test
    public void demo06() {
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
        Optional<String> reduced = list.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }

    @Test
    public void demo07() {
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
    }

    @Test
    public void demo08() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
    }

    @Test
    public void demo09() {
        People people = new People();
        people.setAge(12);
        People people1 = new People();
        people1.setAge(13);
        System.out.println("People：" + people.getAge());
        System.out.println("People1：" + people1.getAge());
    }

    @Test
    public void demo10() {
        String str = "13576542323";
        System.out.println(str.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
    }

    @Test
    public void demo11() {
        BigDecimal b1 = new BigDecimal("5.7640");
        BigDecimal b2 = new BigDecimal("5.764");
        System.out.println(b2.compareTo(b1));
    }

}
