package other.other2019_02.inherit;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * 测试
 *
 * @author 余修文
 * @date 2019/2/19 11:02
 */
public class HelloWorldDemo01 {

    public static void main(String[] args) {
        String str = "测试aBcDeFg123";
        System.out.println(str.toUpperCase());
        str = str.toUpperCase();
        System.out.println(str);
    }

    @Test
    public void demo01() {
        Date date = new DateTime(new Date()).minusMonths(1).toDate();
        System.out.println(getDateYearOrMonth(date, Calendar.YEAR) + "\n" + getDateYearOrMonth(date, Calendar.MONTH));
    }

    private Integer getDateYearOrMonth(Date date, Integer calendarType) {
        Integer yearOrMonth = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendarType == Calendar.YEAR) {
            yearOrMonth = calendar.get(Calendar.YEAR);
        } else if (calendarType == Calendar.MONTH) {
            yearOrMonth = calendar.get(Calendar.MONTH) + 1;
        }
        return yearOrMonth;
    }

}
