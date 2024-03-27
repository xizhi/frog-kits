package vip.frog.kits.times;

import java.util.Date;

class PeriodOfDateUtil {


    public static PeriodOfDate intersection(PeriodOfDate a, PeriodOfDate b) {
        if (a == null || b == null) {
            return PeriodOfDate.empty();
        }
        if (a.isEmpty() || b.isEmpty()) {
            return PeriodOfDate.empty();
        }

        Date start = max(a.getStart(), b.getStart());
        Date end = min(a.getEnd(), b.getEnd());

        if (end.before(start)) {
            return PeriodOfDate.empty();
        }
        return PeriodOfDate.of(start, end);
    }

    static Date max(Date a, Date b) {
        return new Date(Math.max(a.getTime(), b.getTime()));
    }

    static Date min(Date a, Date b) {
        return new Date(Math.min(a.getTime(), b.getTime()));
    }

}
