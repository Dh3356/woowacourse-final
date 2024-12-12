package menu.model.vo.coach_name;

public class CoachName {

    protected static final int COACH_NAME_LENGTH_MIN = 2;
    protected static final int COACH_NAME_LENGTH_MAX = 4;
    private final String value;

    private CoachName(final String value) {
        validate(value);
        this.value = value;
    }

    public static CoachName from(final String value) {
        return new CoachName(value);
    }

    private void validate(final String value) {
        if (value.length() < COACH_NAME_LENGTH_MIN) {
            throw CoachNameException.tooShort();
        }
        if (value.length() > COACH_NAME_LENGTH_MAX) {
            throw CoachNameException.tooLong();
        }
    }

    @Override
    public String toString() {
        return "CoachName{" +
                "value='" + value + '\'' +
                '}';
    }
}
