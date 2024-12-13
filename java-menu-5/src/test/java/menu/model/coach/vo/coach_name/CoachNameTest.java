package menu.model.coach.vo.coach_name;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoachNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "", " "})
    void 생성_시_이름이_최소_글자수_미만이면_예외_발생(String input) {

        // When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CoachName.from(input))
                .isInstanceOf(CoachNameException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaa", "aaaaaa"})
    void 생성_시_이름이_최대_글자수_초과이면_예외_발생(String input) {

        // When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CoachName.from(input))
                .isInstanceOf(CoachNameException.class);
    }
}
