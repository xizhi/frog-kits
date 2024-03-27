package vip.frog.kits.times;

import java.util.Date;
import java.util.Objects;

public class PeriodOfDate {

    private final Date start;
    private final Date end;

    private final long duration;

    PeriodOfDate() {
        this.start = null;
        this.end = null;
        this.duration = 0;
    }

    PeriodOfDate(Date start, Date end) {
        this.start = start;
        this.end = end;
        this.duration = end.getTime() - start.getTime();
    }

    //
    //
    //

    /**
     *
     * @param point
     * @return
     */
    public boolean inTime(Date point) {
        if (point == null) {
            return false;
        }
        if (this.isEmpty()) {
            return false;
        }
        return point.after(start) && point.before(end);
    }


    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return this.duration == 0;
    }

    /**
     *
     * @param otherPeriod
     * @return
     */
    public PeriodOfDate intersection(PeriodOfDate otherPeriod) {
        return PeriodOfDateUtil.intersection(this, otherPeriod);
    }


    //
    //
    //

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public long getDuration() {
        return duration;
    }


    @Override
    public String toString() {
        return "Period{" +
                "start=" + start +
                ", end=" + end +
                ", duration=" + duration +
                '}';
    }

    //
    // static
    //

    public static PeriodOfDate empty() {
        return new PeriodOfDate();
    }

    public static PeriodOfDate of(Date start, Date end) {
        Objects.requireNonNull(start, "start date is null");
        Objects.requireNonNull(end, "end date is null");

        if (end.before(start)) {
            return new PeriodOfDate(start, end);
        }

        return new PeriodOfDate(start, end);
    }
}
