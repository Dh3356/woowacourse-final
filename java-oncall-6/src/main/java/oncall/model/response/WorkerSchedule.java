package oncall.model.response;

import oncall.model.DayOfWeek;
import oncall.model.Month;
import oncall.model.Worker;

public record WorkerSchedule(Month month, int day, DayOfWeek dayOfWeek, Worker worker, boolean isDayOff) {
    @Override
    public String toString() {
        return "WorkerSchedule{" +
                "month=" + month +
                ", day=" + day +
                ", dayOfWeek=" + dayOfWeek +
                ", worker=" + worker +
                ", isDayOff=" + isDayOff +
                '}';
    }
}
