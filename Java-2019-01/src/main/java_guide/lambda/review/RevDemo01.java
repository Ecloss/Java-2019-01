package lambda.review;

import lambda.bo.PersonBo;
import lambda.function_interface.Converter;
import lambda.function_interface.Formula;
import lambda.function_interface.PersonFactory;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * demo
 *
 * @author 余修文
 * @date 2019/4/3 8:41
 */
public class RevDemo01 {

    @Test
    public void demo01() {
        Formula formula = new Formula() {
            @Override
            public double calulate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.calulate(121));
        System.out.println(formula.sqrt(64));
    }

    @Test
    public void demo02() {
        Formula formula = a -> Math.sqrt(a);
        System.out.println(formula.calulate(144));
        System.out.println(formula.sqrt(81));
    }

    @Test
    public void demo03() {
        List<Integer> list = new ArrayList<>(10);
        list.add(6);
        list.add(8);
        list.add(3);
        list.add(5);
        list.add(12);
        list.add(18);
        list.add(0);
        list.add(-1);
        list.add(-3);
        Collections.sort(list, (Integer a, Integer b) -> b.compareTo(a));
        System.out.println(list.toString());
    }

    @Test
    public void demo04() {
        List<Integer> list = new ArrayList<>(10);
        list.add(6);
        list.add(8);
        list.add(3);
        list.add(5);
        list.add(12);
        list.add(18);
        list.add(0);
        list.add(-1);
        list.add(-3);
        Collections.sort(list, Integer::compareTo);
        System.out.println(list.toString());
    }

    @Test
    public void demo05() {
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        System.out.println(converter.convert("123"));
    }

    @Test
    public void demo06() {
        Converter<String, Integer> converter = Integer::valueOf;
        System.out.println(converter.convert("567" + "1"));
    }

    @Test
    public void demo07() {
        Converter<Integer, String> converter = String::valueOf;
        System.out.println(converter.convert(567 + 1));
        String str = converter.convert(123 + 1);
    }

    @Test
    public void demo08() {
        Converter<String, String> converter = from -> String.valueOf(from.charAt(0));
        System.out.println(converter.convert("Yueel"));
    }

    @Test
    public void demo09() {
        PersonFactory<PersonBo> factory = (String firstName, String lastName) -> new PersonBo(firstName, lastName);
        PersonBo personBo = factory.create("Yueel", "Liang");
        System.out.println(personBo.toString());
    }

    Integer integer = new Integer(10);
    @Test
    public void demo10() {
        Converter<Integer, String> converter = from -> String.valueOf(from + integer);
        System.out.println(converter.convert(12));
    }

    @Test
    public void demo11() {
        Converter<String, Integer> converter = from -> Integer.valueOf("12" + from);
        System.out.println(converter.convert("12"));
    }

}
