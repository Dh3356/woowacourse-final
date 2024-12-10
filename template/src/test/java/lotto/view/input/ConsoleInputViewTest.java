package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.view.exception.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ConsoleInputView 테스트")
public class ConsoleInputViewTest {

    private static final String PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private static final ConsoleInputView consoleInputView = new ConsoleInputView();
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setOut(System.out);
        System.setIn(System.in);
        Console.close();
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1000", "2000", "3000", "2947"})
    void 정수를_입력받는다(String input) {

        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int actual = consoleInputView.input();

        // then
        assertThat(outputStreamCaptor.toString()).contains(PURCHASE_MONEY_MESSAGE);
        assertThat(actual).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1000l", "2000,", "3000^", "2n947"})
    void 정수로_입력하지_않으면_예외가_발생한다(String input) {

        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(consoleInputView::input)
                .isInstanceOf(InvalidInputException.class);
    }
}
