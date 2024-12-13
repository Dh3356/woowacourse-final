package menu.model.coach.vo.coach_name;

import java.util.Objects;

public class CoachName {

    protected static final int MIN_LENGTH = 2;
    protected static final int MAX_LENGTH = 4;
    private final String value;

    private CoachName(String value) {
        validate(value);
        this.value = value;
    }

    public static CoachName from(String value) {
        return new CoachName(value);
    }

    private void validate(String value) {
        if (value.length() < MIN_LENGTH) {
            throw CoachNameException.tooShort();
        }
        if (value.length() > MAX_LENGTH) {
            throw CoachNameException.tooLong();
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CoachName{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CoachName coachName = (CoachName) o;
        return Objects.equals(value, coachName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
