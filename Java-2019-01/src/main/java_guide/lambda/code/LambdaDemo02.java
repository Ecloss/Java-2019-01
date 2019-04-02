package lambda.code;

import org.junit.Test;

/**
 * Lambda表达式
 *
 * @author 余修文
 * @date 2019/4/2 17:15
 */
public class LambdaDemo02 {

    final int num = 1;


    @Test
    public void demo01() {
        // 返回一个String
        Converter<Integer, String> converter = from -> String.valueOf(from + num);
        System.out.println(converter.convert(12));
    }


    Integer integer = new Integer(10);

    @Test
    public void demo02() {
        Converter<Integer, String> converter = from -> String.valueOf(from + integer);
        integer++;
        System.out.println(converter.convert(12));
    }

    @Test
    public void demo03() {
        //int qw = 1;
        //Converter<Integer, String> stringConverter =
        //        (from) -> String.valueOf(from + qw);
        //qw = 3;//在lambda表达式中试图修改num同样是不允许的。
    }

    @Test
    public void demo04() {

    }


}


class Lambda1 {
    static int outStaticNum;
    int outerNum;

    void testScope() {
        Converter<Integer, String> converter = from -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> converter1 = from -> {
            outStaticNum = 72;
            return String.valueOf(from);
        };
    }
}