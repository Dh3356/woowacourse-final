package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class DelimiterFactory {

    private final List<Delimiter> defaultDelimiters = List.of(Delimiter.from(":"), Delimiter.from(","));
    private final CustomDelimiterExtractor customDelimiterExtractor;

    public DelimiterFactory(CustomDelimiterExtractor customDelimiterExtractor) {
        this.customDelimiterExtractor = customDelimiterExtractor;
    }

    public List<Delimiter> getDelimiters(String input) {
        List<Delimiter> delimiters = new ArrayList<>(defaultDelimiters);
        if (customDelimiterExtractor.isCustomDelimiterExists(input)) {
            delimiters.add(Delimiter.from(customDelimiterExtractor.extract(input)));
        }
        return delimiters;
    }
}
