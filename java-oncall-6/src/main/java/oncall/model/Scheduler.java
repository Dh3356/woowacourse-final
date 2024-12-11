package oncall.model;

import oncall.model.policy.DayOffPolicy;

public class Scheduler {

    private final DayOffPolicy dayOffPolicy;

    public Scheduler(final DayOffPolicy dayOffPolicy) {
        this.dayOffPolicy = dayOffPolicy;
    }

    public void setSchedule(final Schedule schedule) {
    }
}
