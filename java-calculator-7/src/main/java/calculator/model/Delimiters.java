package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private final List<Delimiter> values;

    private Delimiters(List<Delimiter> value) {
        this.values = value;
    }

    public static Delimiters fromFactory(String input, DelimiterFactory delimiterFactory) {
        return new Delimiters(delimiterFactory.getDelimiters(input));
    }

    public List<Integer> extract(String input) {
        List<String> extracted = new ArrayList<>();
        extracted.add(input);
        for (Delimiter value : values) {
            List<String> temp = new ArrayList<>();
            extracted.forEach(e -> temp.addAll(value.split(e)));
            extracted = temp;
        }
        return extracted.stream().map(Integer::parseInt).toList();
    }

    @Override
    public String toString() {
        return "Delimiters{" +
                "values=" + values +
                '}';
    }
}
