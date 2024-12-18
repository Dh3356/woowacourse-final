package lotto.common.exception;

public interface CustomException {

    static String formatMessageWithDetails(String message, String... details) {
        StringBuilder stringBuilder = new StringBuilder(message);
        for (String detail : details) {
            stringBuilder.append(" ");
            stringBuilder.append(detail);
        }
        return stringBuilder.toString();
    }
}
