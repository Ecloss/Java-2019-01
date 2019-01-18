package other.other2019_01;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * DateTime工具类
 *
 * @author 余修文
 * @date 2019/1/18 9:52
 */
public class DateTimeUtil {

    public static void demo01(Integer type, String startDate, String endDate) {
        DateTime dateTime = new DateTime();
        Date startDateNew = null;
        Date endDateNew = null;
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTimeFormatter formatter1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        switch (type) {
            case 1:
                startDateNew = dateTime.withTimeAtStartOfDay().toDate();
                endDateNew = dateTime.plusDays(1).withTimeAtStartOfDay().minusMillis(1).toDate();
                break;
            case 2:
                startDateNew = dateTime.dayOfWeek().withMinimumValue().withTimeAtStartOfDay().toDate();
                endDateNew = dateTime.plusDays(1).withTimeAtStartOfDay().minusMillis(1).toDate();
                break;
            case 3:
                startDateNew = dateTime.dayOfMonth().withMinimumValue().withTimeAtStartOfDay().toDate();
                endDateNew = dateTime.withTimeAtStartOfDay().toDate();
                break;
            default: break;
        }

    }

    public static void demo02() {

    }

}
