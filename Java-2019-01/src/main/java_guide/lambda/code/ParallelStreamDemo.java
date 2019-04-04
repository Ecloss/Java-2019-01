package lambda.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 并行流
 *
 * @author 余修文
 * @date 2019/4/3 18:15
 */
public class ParallelStreamDemo {

    public List<String> demo01() {
        int max = 100000;
        List<String> list = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            list.add(uuid.toString());
        }
        return list;
    }

    /**
     * 串行排序
     * 耗时：245
     */
    @Test
    public void demo02() {
        List<String> list = demo01();
        long t0 = System.nanoTime();
        long count = list.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long mills = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", mills));
    }

    /**
     * 并行排序
     * 耗时：239
     */
    @Test
    public void demo03() {
        List<String> list = demo01();
        long t0 = System.nanoTime();
        long count =list.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

}
