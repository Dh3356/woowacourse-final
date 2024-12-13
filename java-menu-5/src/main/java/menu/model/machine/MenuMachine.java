package menu.model.machine;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import camp.nextstep.edu.missionutils.Randoms;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.model.category.Category;
import menu.model.coach.Coach;
import menu.model.menu.Menu;

public class MenuMachine {

    protected static final int MIN_COACH_SIZE = 2;
    protected static final int MAX_COACH_SIZE = 5;
    protected static final List<DayOfWeek> days = List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);

    public void validateCoaches(List<Coach> coaches) {
        if (Set.copyOf(coaches).size() != coaches.size()) {
            throw MenuMachineException.coachConflict();
        }
        if (coaches.size() < MIN_COACH_SIZE) {
            throw MenuMachineException.tooMiniCoaches();
        }
        if (coaches.size() > MAX_COACH_SIZE) {
            throw MenuMachineException.tooManyCoaches();
        }
    }

    public List<MenuSuggestionResponse> suggestMenus(List<Coach> coaches) {
        List<MenuSuggestionResponse> response = new ArrayList<>();
        for (DayOfWeek dayOfWeek : days) {
            Category category = getCategory(coaches, response);
            List<MenuResponse> menuResponses = getMenuResponses(coaches, response);

            response.add(new MenuSuggestionResponse(dayOfWeek, category, menuResponses));
        }
        return response;
    }

    private Category getCategory(List<Coach> coaches, List<MenuSuggestionResponse> menuSuggestionResponses) {
        while (true) {
            Category category = selectCategory();
            if (sizeOfMenuSuggestionResponseByCategory(menuSuggestionResponses, category) != 2
                    && isAllCoachCanEat(coaches, category)) {
                return category;
            }
        }
    }

    private boolean isAllCoachCanEat(List<Coach> coaches, Category category) {
        Set<Menu> allUnableMenus = new HashSet<>();
        coaches.forEach(coach -> {
            allUnableMenus.addAll(coach.getUnableMenus());
        });
        return !allUnableMenus.containsAll(Menu.fromCategory(category));
    }

    private long sizeOfMenuSuggestionResponseByCategory(
            List<MenuSuggestionResponse> menuSuggestionResponses,
            Category category) {

        return menuSuggestionResponses.stream()
                .filter(menuSuggestionResponse -> menuSuggestionResponse.getCategory() == category)
                .count();
    }

    private Category selectCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        return Category.values()[randomNumber - 1];
    }

    private List<MenuResponse> getMenuResponses(
            List<Coach> coaches,
            List<MenuSuggestionResponse> menuSuggestionResponses) {

        return coaches.stream()
                .map(coach -> suggestMenu(coach, menuSuggestionResponses))
                .collect(Collectors.toList());
    }

    private MenuResponse suggestMenu(Coach coach, List<MenuSuggestionResponse> menuSuggestionResponses) {
        while (true) {
            Menu menu = selectMenu();
            if (isAlreadySuggestedMenu(coach, menu, menuSuggestionResponses)
                    || coach.isUnableMenu(menu)) {
                continue;
            }
            return new MenuResponse(coach, menu);
        }
    }

    private boolean isAlreadySuggestedMenu(
            Coach coach,
            Menu menu,
            List<MenuSuggestionResponse> menuSuggestionResponses) {

        List<MenuResponse> responses = new ArrayList<>();
        menuSuggestionResponses.forEach(
                menuSuggestionResponse -> responses.addAll(menuSuggestionResponse.getMenuResponses())
        );
        return responses.stream()
                .filter(response -> response.getCoach().equals(coach))
                .map(MenuResponse::getMenu)
                .collect(Collectors.toList()).contains(menu);
    }

    private Menu selectMenu() {
        List<String> menus = Arrays.stream(Menu.values()).map(Menu::getName).collect(Collectors.toList());
        return Menu.from(Randoms.shuffle(menus).get(0));
    }
}
