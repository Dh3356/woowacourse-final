package menu.view.output;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.category.Category;
import menu.model.machine.MenuSuggestionResponse;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    @Override
    public void printMenuSuggestionResponses(List<MenuSuggestionResponse> menuSuggestionResponses) {
        System.out.println("메뉴 추천 결과입니다.");
        printDayOfWeeks(menuSuggestionResponses);
        printCategories(menuSuggestionResponses);
        printMenuResponses(menuSuggestionResponses);
    }

    @Override
    public void printEndMessage() {
        System.out.println("추천을 완료했습니다.");
    }

    private void printDayOfWeeks(List<MenuSuggestionResponse> menuSuggestionResponses) {
        List<String> dayOfWeeks = menuSuggestionResponses.stream()
                .map(MenuSuggestionResponse::getDayOfWeek)
                .map(this::mapDayOfWeeksToKor)
                .collect(Collectors.toList());

        System.out.printf("[ 구분 | %s ]\n", String.join(" | ", dayOfWeeks));
    }

    private void printCategories(List<MenuSuggestionResponse> menuSuggestionResponses) {
        List<String> categories = menuSuggestionResponses.stream()
                .map(MenuSuggestionResponse::getCategory)
                .map(Category::getName)
                .collect(Collectors.toList());
        System.out.printf("[ 카테고리 | %s ]\n", String.join(" | ", categories));
    }

    private void printMenuResponses(List<MenuSuggestionResponse> menuSuggestionResponses) {
        int size = menuSuggestionResponses.get(0).getMenuResponses().size();
        for (int i = 0; i < size; i++) {
            String coachName = menuSuggestionResponses.get(0).getMenuResponses().get(i).getCoach().getName();
            List<String> menus = new ArrayList<>();
            int finalI = i;
            menuSuggestionResponses.stream()
                    .map(MenuSuggestionResponse::getMenuResponses)
                    .forEach(menuResponses -> menus.add(menuResponses.get(finalI).getMenu().getName()));

            System.out.printf("[ %s | %s ]\n", coachName, String.join(" | ", menus));
        }
    }

    private String mapDayOfWeeksToKor(DayOfWeek dayOfWeek) {
        if (dayOfWeek == MONDAY) {
            return "월요일";
        }
        if (dayOfWeek == TUESDAY) {
            return "화요일";
        }
        if (dayOfWeek == WEDNESDAY) {
            return "수요일";
        }
        if (dayOfWeek == THURSDAY) {
            return "목요일";
        }
        return "금요일";
    }
}
