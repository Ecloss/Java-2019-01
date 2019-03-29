package java_util;

import org.junit.Test;

import org.junit.Test;

import java.util.Arrays;

/**
 * 测试数组
 *
 * @author 余修文
 * @date 2019/3/28 15:28
 */
public class TestArrays {

    /**
     * 1. 排序
     * 2. 查找
     * 3. 比较
     * 4. 填充
     * 5. 转列表
     * 6. 转字符串
     */
    @Test
    public void demo01() {
        int a[] = {1, 3, 2, 7, 6, 5, 4, 9};
        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void demo02() {
        int a[] = {1, 3, 2, 7, 6, 5, 4, 9};
        Arrays.sort(a, 2, 6);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void demo03() {
        int a[] = {1, 3, 2, 7, 6, 5, 4, 9};
        Arrays.parallelSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void demo04() {
        char a[] = {'d', 'c', 'r', 'g', 'b'};
        Arrays.parallelSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void demo05() {
        int a[] = {1, 3, 2, 7, 6, 5, 4, 9};
        Arrays.fill(a, 8);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void demo06() {
        int a[] = {1, 3, 2, 7, 6, 5, 4, 9};
        Arrays.fill(a, 0, 3, 11);
        System.out.println(Arrays.toString(a));
    }

}
