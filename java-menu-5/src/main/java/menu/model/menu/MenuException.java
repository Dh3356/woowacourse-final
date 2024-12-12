package menu.model.menu;


import menu.exception.CustomException;

public class MenuException extends IllegalArgumentException implements CustomException {

    private static final String MENU_CONFLICT_MESSAGE = "메뉴가 중복됩니다.";
    private static final String MENU_NOT_FOUND_MESSAGE = "존재하지 않는 메뉴입니다.";

    private MenuException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException conflict(final String... details) {
        return new MenuException(MENU_CONFLICT_MESSAGE);
    }

    public static IllegalArgumentException notFound(final String... details) {
        return new MenuException(MENU_NOT_FOUND_MESSAGE);
    }
}
