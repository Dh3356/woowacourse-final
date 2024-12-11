package oncall.model.policy;

import static oncall.model.DayOfWeek.SATURDAY;
import static oncall.model.DayOfWeek.SUNDAY;
import static oncall.model.Month.AUGUST;
import static oncall.model.Month.DECEMBER;
import static oncall.model.Month.JANUARY;
import static oncall.model.Month.JUNE;
import static oncall.model.Month.MARCH;
import static oncall.model.Month.MAY;
import static oncall.model.Month.OCTOBER;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import oncall.model.DayOfWeek;
import oncall.model.Month;

public class DefaultDayOffPolicy implements DayOffPolicy {

    private static final Map<Month, Set<Integer>> offDays;

    static {
        offDays = new HashMap<>();
        offDays.put(JANUARY, Set.of(1));
        offDays.put(MARCH, Set.of(1));
        offDays.put(MAY, Set.of(5));
        offDays.put(JUNE, Set.of(6));
        offDays.put(AUGUST, Set.of(15));
        offDays.put(OCTOBER, Set.of(3, 9));
        offDays.put(DECEMBER, Set.of(25));
    }

    @Override
    public boolean isDayOff(final Month month, final int day, final DayOfWeek dayOfWeek) {
        if (isWeekEnd(dayOfWeek)) {
            return true;
        }
        if (offDays.containsKey(month)) {
            return offDays.get(month).contains(day);
        }
        return false;
    }

    private boolean isWeekEnd(final DayOfWeek dayOfWeek) {
        return dayOfWeek == SATURDAY || dayOfWeek == SUNDAY;
    }
}
