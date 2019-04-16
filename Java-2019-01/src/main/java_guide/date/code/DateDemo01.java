package date.code;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期相关API
 *
 * @author 余修文
 * @date 2019/4/4 10:57
 */
public class DateDemo01 {

    /**
     * Clock 类提供了访问当前的日期和方法，Clock
     */
    @Test
    public void demo01() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacDate = Date.from(instant);
        System.out.println(legacDate);
    }

    @Test
    public void demo02() {
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));
    }

    /**
     * LocalTime
     */
    @Test
    public void demo03() {
        LocalDateTime rightNow = LocalDateTime.now();
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);
        System.out.println(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(rightNow));
    }

}
