package oncall.model.policy;

import oncall.model.DayOfWeek;
import oncall.model.Month;

public interface DayOffPolicy {

    boolean isDayOff(final Month month, final int day, final DayOfWeek dayOfWeek);
}
