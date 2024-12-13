package menu.model.coach;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import menu.model.menu.Menu;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CoachTest {

    static Stream<Arguments> 못_먹는_메뉴_추가_테스트_케이스() {
        return Stream.of(
                Arguments.of(List.of(Menu.BAGUETTE, Menu.QUICHE)),
                Arguments.of(List.of(Menu.QUICHE))
        );
    }

    static Stream<Arguments> 못_먹는_메뉴인지_확인_테스트_케이스() {
        return Stream.of(
                Arguments.of(makeCoach(List.of(Menu.BAGUETTE, Menu.QUICHE)), Menu.BAGUETTE, true),
                Arguments.of(makeCoach(List.of(Menu.QUICHE)), Menu.QUICHE, true),
                Arguments.of(makeCoach(List.of(Menu.BAGUETTE, Menu.QUICHE)), Menu.BULGOGI, false),
                Arguments.of(makeCoach(List.of(Menu.QUICHE)), Menu.BAGUETTE, false)
        );
    }

    private static Coach makeCoach(List<Menu> unableMenus) {
        Coach coach = Coach.from("abc");
        coach.addUnableMenus(unableMenus);
        return coach;
    }

    @ParameterizedTest
    @MethodSource("못_먹는_메뉴_추가_테스트_케이스")
    void 못_먹는_메뉴_추가(List<Menu> menusToAdd) {

        // Given
        Coach coach = Coach.from("abc");
        List<Menu> expected = coach.getUnableMenus();

        // When
        coach.addUnableMenus(menusToAdd);
        List<Menu> actual = List.copyOf(menusToAdd);

        // Then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("못_먹는_메뉴인지_확인_테스트_케이스")
    void 못_먹는_메뉴인지_확인(Coach coach, Menu menu, boolean expected) {

        // When
        boolean actual = coach.isUnableMenu(menu);

        // Then
        assertThat(actual).isEqualTo(expected);
    }
}
