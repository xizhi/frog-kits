package vip.frog.kits.times.date;


/**
 * date
 */
public class DateKits {

    /**
     *
     */
    public static final DateFormat format = new DateFormat();

    /**
     *
     */
    public static final DateParser parser = new DateParser();

    /**
     * @return
     */
    public static DateBuilder builder() {
        return DateBuilder.create();
    }

}
