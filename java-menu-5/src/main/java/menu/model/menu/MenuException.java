package menu.model.menu;

import menu.exception.CustomException;

public class MenuException extends IllegalArgumentException implements CustomException {

    private static final String NOT_FOUND = "존재하지 않는 메뉴입니다.";

    private MenuException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException notFound(final String... details) {
        return new MenuException(NOT_FOUND, details);
    }
}
