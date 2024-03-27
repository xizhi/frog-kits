package vip.frog.kits.times.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间构建器
 */
public class DateBuilder {

    private static final Logger log = LoggerFactory.getLogger(DateBuilder.class);

    boolean _strict = false;

    int _year = 0;
    int _month = 0;
    int _dayOfMonth = 1;


    int _hourOfDay = 0;
    int _minute = 0;
    int _second = 0;

    int _millisecond = 0;

    public static DateBuilder create() {
        return new DateBuilder();
    }

    /**
     * 设置严格模式
     *
     * @param strict
     * @return
     */
    public DateBuilder strict(boolean strict) {
        this._strict = strict;
        return this;
    }

    protected void throwRuntimeException(String message) {
        throw new RuntimeException(message);
    }

    public DateBuilder year(int year) {
        if (year > 1900) {
            this._year = year;
        } else if (this._strict) {
            throw new RuntimeException("invalid year value : " + year);
        } else {
            log.warn("invalid year value : {}", year);
        }

        return this;
    }

    public DateBuilder month(int month) {
        this._month = month;
        return this;
    }

    /**
     *
     * @param month
     * @return
     */
    public DateBuilder monthOfHuman(int month) {
        month(month - 1);
        return this;
    }

    public DateBuilder dayOfMonth(int dayOfMonth) {
        this._dayOfMonth = dayOfMonth;
        return this;
    }

    public DateBuilder hourOfDay(int hourOfDay) {
        this._hourOfDay = hourOfDay;
        return this;
    }

    public DateBuilder minute(int minute) {
        this._minute = minute;
        return this;
    }

    /**
     * 设置秒
     * 无效的数值会被忽略,并输出警告日志
     *
     * @param second
     * @return
     */
    public DateBuilder second(int second) {
        if (second > 0 && second < 59) {
            this._second = second;
        } else {
            log.warn("invalid second value : {}", second);
        }
        return this;
    }

    /**
     * 设置毫秒
     * 无效的数值会被忽略,并输出警告日志
     *
     * @param millisecond
     * @return
     */
    public DateBuilder millisecond(int millisecond) {
        this._millisecond = millisecond;
        return this;
    }

    public DateBuilder day(int year, int month, int date) {
        this._year = year;
        this._month = month;
        this._dayOfMonth = date;
        return this;
    }

    public DateBuilder dayOfHuman(int year, int month, int dayOfMonth) {
        this._year = year;
        monthOfHuman(month);
        dayOfMonth(dayOfMonth);
        return this;
    }

    public DateBuilder time(int hourOfDay, int minute, int second) {
        hourOfDay(hourOfDay);
        minute(minute);
        second(second);
        return this;
    }

    public DateBuilder nowOfDay() {
        return this;
    }

    public DateBuilder nowOfTime() {
        return this;
    }

    public Date get() {
        final Calendar calendar = Calendar.getInstance();
        if (_year == 0) {
            _year = LocalDate.now().getYear();
        }

        //noinspection MagicConstant
        calendar.set(
                this._year,
                this._month,
                this._dayOfMonth,
                this._hourOfDay,
                this._minute,
                this._second);

        calendar.set(Calendar.MILLISECOND, this._millisecond);
        return calendar.getTime();
    }
}
