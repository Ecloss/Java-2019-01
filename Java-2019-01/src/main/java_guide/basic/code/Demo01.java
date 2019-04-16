package basic.code;

import org.junit.Test;

import java.util.HashMap;

/**
 * demo
 *
 * @author 余修文
 * @date 2019/4/8 8:41
 */
public class Demo01 {

    public static void main(String[] args) {

    }

    @Test
    public void demo01() {
        String a = new String("ab");
        String b = new String("ab");
        String a1 = "ab";
        String b1 = "ab";
        // true
        if (a1 == b1) {
            System.out.println("a1 == b1");
        }
        // false
        if (a == b) {
            System.out.println("a == b");
        }
        // true
        if (a.equals(b)) {
            System.out.println("a.equals(b)");
        }
        // true
        if (a1.equals(b1)) {
            System.out.println("a1.equals(b1)");
        }
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a1.hashCode());
        System.out.println(b1.hashCode());
    }

    @Test
    public void demo02() {
    }

}
