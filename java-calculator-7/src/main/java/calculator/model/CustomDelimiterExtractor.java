package calculator.model;

public class CustomDelimiterExtractor {

    public boolean isCustomDelimiterExists(String input) {
        if (input.startsWith("//")) {
            String next = input.substring(2);
            return next.contains("\\n");
        }
        return false;
    }

    public String extract(String input) {
        if (!isCustomDelimiterExists(input)) {
            throw new IllegalArgumentException("해당 문자열에는 커스텀 구분자가 존재하지 않습니다.");
        }
        return input.substring(2).split("\\\\n")[0];
    }

    public String removeCustomDelimiterFormat(String input) {
        if (!isCustomDelimiterExists(input)) {
            return input;
        }
        return input.split("\\\\n")[1];
    }
}
