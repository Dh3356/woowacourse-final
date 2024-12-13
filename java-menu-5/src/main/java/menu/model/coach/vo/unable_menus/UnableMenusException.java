package menu.model.coach.vo.unable_menus;

import static menu.model.coach.vo.unable_menus.UnableMenus.MAX_SIZE;

import menu.exception.CustomException;

public class UnableMenusException extends IllegalArgumentException implements CustomException {

    private static final String SIZE_OVER_MESSAGE = "못 먹는 음식은 최대 " + MAX_SIZE + "개만 입력 가능합니다.";
    private static final String CONFLICT_MESSAGE = "중복되는 메뉴가 존재합니다.";

    private UnableMenusException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException sizeOver(final String... details) {
        return new UnableMenusException(SIZE_OVER_MESSAGE, details);
    }

    public static IllegalArgumentException conflict(final String... details) {
        return new UnableMenusException(CONFLICT_MESSAGE, details);
    }
}
