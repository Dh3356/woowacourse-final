package oncall.model;

import java.util.Arrays;

public enum DayOfWeek {

    MONDAY("월", 0),
    TUESDAY("화", 1),
    WEDNESDAY("수", 2),
    THURSDAY("목", 3),
    FRIDAY("금", 4),
    SATURDAY("토", 5),
    SUNDAY("일", 6);

    private final String name;
    private final int order;

    DayOfWeek(final String name, final int order) {
        this.name = name;
        this.order = order;
    }

    public static DayOfWeek from(final String name) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("값에 해당하는 요일이 존재하지 않습니다."));
    }

    public DayOfWeek next() {
        int nextOrder = (this.order + 1) % values().length;
        return Arrays.stream(values())
                .filter(value -> value.order == nextOrder)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("다음 요일을 계산하는 데에 실패했습니다."));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
