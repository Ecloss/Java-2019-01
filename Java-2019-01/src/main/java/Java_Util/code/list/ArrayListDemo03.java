package Java_Util.code.list;

import org.junit.Test;

import java.util.ArrayList;

/**
 * ArrayList03 源码深度解析
 *
 * @author 余修文
 * @date 2019/2/27 17:29
 */
public class ArrayListDemo03 {

    @Test
    public void demo01() {
        ArrayList<Object> list = new ArrayList<>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前：" + (endTime - startTime));
        list = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity后： " + (endTime1 - startTime1));
    }

}
