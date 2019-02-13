package Java_Util.code;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * DateTime01
 *
 * @author 余修文
 * @date 2019/1/29 10:20
 */
public class DateTimeDemo01 {

    /**
     * LocalDateTime, Instant, DateTimeFormatter 如何代替 DateTime， Date， SimpleDateTimeFormat
     */
    @Test
    public void demo01() {
        /* 用Instant 代替 Date */
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        Instant instant1 = date.toInstant();
        System.out.println(instant);
        System.out.println(date);
        System.out.println(instant1);
    }

    @Test
    public void demo02() {
        /* 用LocalDateTIme 来代替 Calendar */
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println(year + "-" + month);
        System.out.println(dayOfMonth);
        System.out.println(hour + ":" + minute + ":" + second);
    }

    @Test
    public void demo03() {
        /** 使用DateTimeFormatter 代替 SimpleDateFormat */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
        LocalDateTime parse = LocalDateTime.parse(format, formatter);
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        Instant instant = parse.toInstant(offset);
        System.out.println(instant);
    }

}
