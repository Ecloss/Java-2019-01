package other.other2019_03;

import com.sun.corba.se.pept.transport.ReaderThread;
import org.junit.Test;
import other.other2019_03.day0328.TestInterface;

import java.util.*;

/**
 *
 * @author 余修文
 * @date 2019/3/28 13:52
 */
public class Demo0328 {

    /**
     * Collections 工具类常用方法
     * reverse
     * shuffle
     * sort
     * sort
     * swap
     * robate
     */
    @Test
    public void demo01() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(-1);
        list.add(8);
        list.add(4);
        list.add(12);
        list.add(9);
        list.add(6);
        System.out.println(list.toString());
        // 反转
        //Collections.reverse(list);
        // 随机排序
        //Collections.shuffle(list);
        // 排序
        //Collections.sort(list);
        // 按照自己设定的规则排序
        //Comparator<Integer> comparator = (i1, i2) -> i2.compareTo(i1);
        //TestInterface testInterface = () -> 10;
        //Collections.sort(list, (a,b) -> function(a,b));
        // rotate排序
        Collections.rotate(list, 4);
        System.out.println(list.toString());

    }

    @Test
    public void demo02() {
        TestInterface testInterface = () -> 1;
    }
    public  Integer function(Integer a,Integer b){
        return  1;
    }

}
