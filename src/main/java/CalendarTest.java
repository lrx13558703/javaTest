import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 打印出日历
 */
public class CalendarTest {
    public static void main(String[] args) {
        CalendarTest.testCalendar("2019-12-15");
    }

    public static void testCalendar(String dateStr) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        calendar.set(Calendar.DATE, 1);

        String[] weekday = {"日", "一", "二", "三", "四", "五", "六"};
        for (int i = 0; i < weekday.length; i++) {
            System.out.print(weekday[i] + "\t");
            if (i == 6) {
                System.out.println();
            }
        }

        int days = calendar.getActualMaximum(Calendar.DATE);

        for (int i = 0; i <= calendar.get(Calendar.DAY_OF_WEEK) - 2; i++) {// 根据月初是星期几，判断前面空格的数量。
            System.out.print("\t");
        }
        for (int i = 0; i < days; i++) {
            System.out.print(i + 1 + "\t");
            int weekdays = calendar.get(Calendar.DAY_OF_WEEK);
            if (weekdays == Calendar.SATURDAY) {
                System.out.println();
            }
            calendar.add(Calendar.DATE, 1);
        }
        System.out.println();
    }
}
