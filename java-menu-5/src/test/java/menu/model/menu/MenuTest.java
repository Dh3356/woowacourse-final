package menu.model.menu;

import static menu.model.category.Category.ASIAN_FOOD;
import static menu.model.category.Category.CHINESE_FOOD;
import static menu.model.category.Category.JAPANESE_FOOD;
import static menu.model.category.Category.KOREAN_FOOD;
import static menu.model.category.Category.WESTERN_FOOD;
import static menu.model.menu.Menu.KHAO_PAD;
import static menu.model.menu.Menu.PANINI;
import static menu.model.menu.Menu.SWEET_AND_SOUR_PORK;
import static menu.model.menu.Menu.TOM_YUM_GOONG;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import menu.model.category.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MenuTest {

    static Stream<Arguments> 이름으로_메뉴_얻기_테스트() {
        return Stream.of(
                Arguments.of("파니니", PANINI),
                Arguments.of("똠얌꿍", TOM_YUM_GOONG),
                Arguments.of("카오 팟", KHAO_PAD),
                Arguments.of("탕수육", SWEET_AND_SOUR_PORK)
        );
    }

    static Stream<Arguments> 카테고리로_메뉴들_얻기_테스트_케이스() {
        return Stream.of(
                Arguments.of(JAPANESE_FOOD),
                Arguments.of(KOREAN_FOOD),
                Arguments.of(CHINESE_FOOD),
                Arguments.of(ASIAN_FOOD),
                Arguments.of(WESTERN_FOOD)
        );
    }

    @ParameterizedTest
    @MethodSource("이름으로_메뉴_얻기_테스트")
    void 이름으로_메뉴_얻기(String name, Menu expected) {

        // When
        Menu actual = Menu.from(name);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("카테고리로_메뉴들_얻기_테스트_케이스")
    void 카테고리로_메뉴들_얻기(Category category) {

        // When & Then
        Menu.fromCategory(category)
                .forEach(menu -> {
                    assertThat(menu.getCategory()).isEqualTo(category);
                });
    }
}
