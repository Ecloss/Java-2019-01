package lambda.code;

import lambda.bo.PersonBo;
import lambda.function_interface.Converter;
import lambda.function_interface.Formula;
import lambda.function_interface.PersonFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 默认方法
 *
 * @author 余修文
 * @date 2019/4/2 16:39
 */
public class Demo01 {

    public static void main(String[] args) {
        // 实现一个对象，并且匿名实现了这个接口的类
        Formula formula = new Formula() {
            @Override
            public double calulate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.calulate(100));
        System.out.println(formula.sqrt(16));
    }

    @Test
    public void demo01() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println(names.toString());
    }

    @Test
    public void demo02() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
    }

    /**
     * 函数式接口FunctionInterface
     */
    @Test
    public void demo03() {
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass());
    }

    // 通过静态方法来引用
    @Test
    public void demo04() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converte = converter.convert("123");
        System.out.println(converte.getClass());
    }

    @Test
    public void demo05() {
        Something something = new Something();
        Converter<String, String> converter = Something::startWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }

    /**
     * 使用构造器来表达Lambda式
     */
    @Test
    public void demo06() {
        // PersonBo::new 是用来实现PersonFactory 接口的，并且通过Person的构造器
        PersonFactory<PersonBo> personFactory = PersonBo::new;
        PersonBo personBo = personFactory.create("Peter", "Parker");
    }

    /**
     * 在Lambda表达式中访问外部的局部变量
     */
    @Test
    public void demo07() {
        final int num = 1;
        Converter<Integer, String> converter = from -> String.valueOf(from + num);
        System.out.println(converter.convert(100));
    }

    @Test
    public void demo08() {
        final String str = "12";
        Converter<String , Integer> converter = from -> Integer.valueOf(from + str);
        System.out.println(converter.convert("04"));
    }

}

class Something {
    static String startWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

// 构造函数，使用关键字来引用
