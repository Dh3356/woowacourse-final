package menu.model.coach.vo.unable_menus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import menu.model.menu.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UnableMenusTest {

    static Stream<Arguments> 메뉴_추가_시_용량을_초과하면_예외_발생_테스트_케이스() {
        return Stream.of(
                Arguments.of(List.of(Menu.BAGUETTE, Menu.QUICHE, Menu.BANH_MI)),
                Arguments.of(List.of(Menu.QUICHE, Menu.HIGH_RICE, Menu.BULGOGI, Menu.BUN_CHA))
        );
    }

    static Stream<Arguments> 메뉴_추가_시_중복_메뉴가_있으면_예외_발생_테스트_케이스() {
        return Stream.of(
                Arguments.of(List.of(Menu.BAGUETTE, Menu.BAGUETTE, Menu.BANH_MI)),
                Arguments.of(List.of(Menu.QUICHE, Menu.HIGH_RICE, Menu.HIGH_RICE, Menu.BUN_CHA))
        );
    }

    static Stream<Arguments> 메뉴_추가_테스트_케이스() {
        return Stream.of(
                Arguments.of(List.of(Menu.BAGUETTE, Menu.BANH_MI)),
                Arguments.of(List.of(Menu.BUN_CHA))
        );
    }

    @Test
    void 빈_리스트로_초기화() {

        // Given
        List<Menu> expected = List.of();

        // When
        List<Menu> actual = UnableMenus.empty().getValues();

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("메뉴_추가_테스트_케이스")
    void 메뉴_추가(List<Menu> menusToAdd) {

        // Given
        UnableMenus menus = UnableMenus.empty();

        // When
        menus.addAll(menusToAdd);

        // Then
        assertThat(menus.getValues().size()).isEqualTo(menusToAdd.size());
    }

    @ParameterizedTest
    @MethodSource("메뉴_추가_시_용량을_초과하면_예외_발생_테스트_케이스")
    void 메뉴_추가_시_용량을_초과하면_예외_발생(List<Menu> menusToAdd) {

        // Given
        UnableMenus unableMenus = UnableMenus.empty();

        // When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> unableMenus.addAll(menusToAdd))
                .isInstanceOf(UnableMenusException.class);
    }

    @ParameterizedTest
    @MethodSource("메뉴_추가_시_중복_메뉴가_있으면_예외_발생_테스트_케이스")
    void 메뉴_추가_시_중복_메뉴가_있으면_예외_발생(List<Menu> menusToAdd) {

        // Given
        UnableMenus unableMenus = UnableMenus.empty();

        // When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> unableMenus.addAll(menusToAdd))
                .isInstanceOf(UnableMenusException.class);
    }
}
