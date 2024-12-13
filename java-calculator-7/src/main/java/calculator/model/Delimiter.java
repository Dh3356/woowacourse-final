package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Delimiter {

    public static final Pattern DIGIT_PATTERN = Pattern.compile("^[0-9]+$");
    private final String value;

    private Delimiter(String value) {
        validate(value);
        this.value = value;
    }

    public static Delimiter from(String value) {
        return new Delimiter(value);
    }

    private void validate(String value) {
        if (DIGIT_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다.");
        }
    }

    public List<String> split(String input) {
        return Arrays.stream(input.split(value)).toList();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Delimiter{" +
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
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(value, delimiter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
