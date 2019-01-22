package Java_Util.code;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String工具类
 *
 * @author 余修文
 * @date 2019/1/22 15:12
 */
public class StringBufferDemo01 {

    @Test
    public void demo01() {
        CharSequence seq = "Hello Kitty";
        System.out.println(seq);
    }

    @Test
    public void demo02() {
        String str = "2019-01-01";
        DateTime dateTime = new DateTime(str);
        Date today = dateTime.withTimeAtStartOfDay().toDate();
        System.out.println("今天最早上：" + today);
        Date tomorrow = dateTime.plusDays(2).withTimeAtStartOfDay().minusMillis(1).toDate();
        System.out.println("明天晚上：" + tomorrow);
        Date thisWeek = dateTime.dayOfWeek().withMinimumValue().withTimeAtStartOfDay().toDate();
        System.out.println("这个周末的开始： " + thisWeek);
        Date thisWeekEnd = dateTime.dayOfWeek().withMaximumValue().plusDays(1).minusMillis(1).toDate();
        System.out.println("这个周末的结束：" + thisWeekEnd);
    }

    @Test
    public void demo03() throws ParseException {
        String str = "2018-12-12";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(str);
    }

    @Test
    public void demo04() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-ss");
        String str = "2018-12-12";
        Date date = DateTime.parse(str, dateTimeFormatter).toDate();
        System.out.println(date);
    }

    @Test
    public void demo05() {
        System.out.println("2018-12-12");
        Date date = new Date();
        System.out.println(date);
        System.out.println("!@#$%^&*()_+");
    }

}
