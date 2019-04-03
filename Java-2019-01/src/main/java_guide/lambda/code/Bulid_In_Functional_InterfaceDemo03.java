package lambda.code;

import lambda.function_interface.test_interface.PredicateDemo01;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 内置函数接口
 *
 * @author 余修文
 * @date 2019/4/3 9:16
 */
public class Bulid_In_Functional_InterfaceDemo03 {

    /**
     * Predicate 表达式
     * 1. test 方法， Boolean
     * 2. and 方法：且方法
     * 3. negate方法：非
     * 4. or 方法：或
     */
    @Test
    public void demo01() {
        // 判断字符串是否长于 5个字符，是则返回true
        PredicateDemo01<String> predicateDemo01 = s -> s.length() > 5;
        predicateDemo01.test("Yuuel");
        // 返回true
        System.out.println(predicateDemo01.test("XiaoBai"));
        // 在字段长度 大于5 的情况下，还需要大于10
        PredicateDemo01<String> predicateDemo02 = predicateDemo01.and(s -> s.length() > 10);
        // 返回false
        System.out.println(predicateDemo02.test("XiaoBai"));
        // 取得PredicateDemo的反结果
        PredicateDemo01<String> predicateDemo03 = predicateDemo01.negate();
        // 返回false
        System.out.println(predicateDemo03.test("XiaoBai"));
        // 取得PredicateDemo的或结果
        PredicateDemo01<String> predicateDemo04 = predicateDemo01.or(s -> s.length() < 3);
        // 返回true
        System.out.println(predicateDemo04.test("X"));
    }

    @Test
    public void demo02() {

    }

}
