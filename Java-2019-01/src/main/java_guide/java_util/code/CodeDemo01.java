package java_util.code;

import java_util.source.ArrayListSource;
import org.junit.Test;

import java.util.*;

/**
 * @author 余修文
 * @date 2019/4/16 13:56
 */
public class CodeDemo01 {

    @Test
    public void demo01() {
        List<Integer> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        ArrayListSource<Integer> list = new ArrayListSource<>(10);
        System.out.printf("Before add:arrayList.size() = %d\n",list.size());

        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        System.out.printf("After add:arrayList.size() = %d\n", list.size());

        System.out.println("Printing elements of arrayList");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();

        System.out.print("for循环遍历:");
        for (Integer num : list) {
            System.out.print(num + "  ");
        }

        // toArray 用法
        // 第一种方式
        Integer[] integers = list.toArray(new Integer[list.size()]);

        // 第二种方式
        Integer[] integers1 = new Integer[list.size()];
        list.toArray(integers1);

        // 向指定位置添加元素
        list.add(2, 123);
        for (Integer num : list) {
            System.out.print(num + "  ");
        }

        list.remove(2);

        list.remove((Object)3);

        list.clear();
    }

    @Test
    public void demo02() {
        // 把线程不安全的集合，编程线程安全的集合
        List list = Collections.synchronizedList(new ArrayListSource<>());
    }

    /**
     * Arrays.copy()
     */
    @Test
    public void demo03() {
        Integer[] a = new Integer[]{1, 3, 5, 7, 9, 2};
        Integer[] b = new Integer[10];
        b = Arrays.copyOf(a, a.length);
        Arrays.asList(b).forEach(i -> System.out.println(i));
    }

    /**
     * System.arrayscopy();
     */
    @Test
    public void demo04() {
        Integer[] a = new Integer[]{1, 3, 5, 7, 9, 12,14};
        Integer[] b = new Integer[10];
        System.arraycopy(a, 2, b, 0, a.length - 2);
        Arrays.asList(b).forEach(i -> System.out.println(i));
    }

}
