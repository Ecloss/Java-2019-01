package other.other2019_03;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author 余修文
 * @date 2019/3/20 10:19
 */
public class Demo0320 {

    @Test
    public void demo01() {
        Integer num = null;
        Integer test = 1;
        if (test.equals(num)) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }
    }

    @Test
    public void demo02() {
        DateTime startTime = DateTime.now().withDayOfMonth(1).withTime(0,0,0,0);
        System.out.println(startTime);
        System.out.println(new DateTime(startTime).plusMonths(1));
    }

    @Test
    public void demo03() {

    }

}
