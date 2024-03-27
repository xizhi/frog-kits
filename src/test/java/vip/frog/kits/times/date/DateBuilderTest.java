package vip.frog.kits.times.date;

import org.junit.Test;

import java.util.Date;

/**
 * {@link DateBuilder}
 */
public class DateBuilderTest {

    @Test
    public void test01() {
        final Date date = DateBuilder.create()
                .day(2024, 3, 27)
                .get();

        System.out.println(date);
    }

}
