package oncall.model;

import java.util.Arrays;

public enum Month {

    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private final int value;
    private final int length;

    Month(int value, int length) {
        this.value = value;
        this.length = length;
    }

    public static Month from(final int value) {
        return Arrays.stream(values())
                .filter(month -> month.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("값에 해당하는 월이 존재하지 않습니다."));
    }

    public int getValue() {
        return value;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Month{" +
                "value=" + value +
                ", length=" + length +
                '}';
    }
}
