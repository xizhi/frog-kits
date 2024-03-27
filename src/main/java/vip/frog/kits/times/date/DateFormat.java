package vip.frog.kits.times.date;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 日期格式化
 */
public class DateFormat {

    public static final String FORMAT_DATE = "yyyy-MM-dd";

    public static final String FORMAT_TIME = "HH:mm:ss";

    public String format(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * @param date
     * @return
     */
    public String day(Date date) {
        return format(date, FORMAT_DATE);
    }

    public String time(Date date) {
        return format(date, FORMAT_TIME);
    }

    public String dayAndTime(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public String dayAndTimeMillisecond(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }

}
