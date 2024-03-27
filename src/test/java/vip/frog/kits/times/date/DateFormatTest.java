package vip.frog.kits.times.date;


import org.junit.Test;
import vip.frog.kits.times.date.DateFormat;

import java.util.Date;

/**
 * {@link DateFormat}
 */
public class DateFormatTest {

    @Test
    public void test01() {

        DateFormat dateFormat = new DateFormat();

        final Date now = new Date();

        System.out.println(dateFormat.day(now));
        System.out.println(dateFormat.time(now));
        System.out.println(dateFormat.dayAndTime(now));
        System.out.println(dateFormat.dayAndTimeMillisecond(now));

    }

}
