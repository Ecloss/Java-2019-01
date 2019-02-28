package Java_Util.code;

import java.util.ArrayList;
import java.util.List;

/**
 * final 的静态变量区别
 *
 * @author 余修文
 * @date 2019/2/27 10:47
 */
public class FinalDemo01 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        // 并集
        list1.addAll(list2);
        // 交集
        list1.containsAll(list2);
        // 差集
        list1.removeAll(list2);
        // 无重复并集
        list2.removeAll(list1);
        list1.addAll(list2);
    }

}
