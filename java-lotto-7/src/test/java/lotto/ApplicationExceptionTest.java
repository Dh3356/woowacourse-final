package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.exception.LottoPurchaseException;
import lotto.model.exception.WinningLottoException;
import lotto.view.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Application 예외 테스트")
public class ApplicationExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String validPurchaseMoneyInput = "1000";
    private static final String validWinningNumberInput = "1,2,3,4,5,6";
    private static final String validBonusNumberInput = "7";

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1000j", "dsf", "hello", "100k"})
    void 로또_구입_금액으로_정수를_입력하지_않은_경우(String input) {

        RuntimeException exception = InvalidInputException.invalidPurchaseMoney();

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE).contains(exception.getMessage());
        });
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"999", "10", "-1"})
    void 로또_구입_금액이_1000원_미만인_경우(String input) {

        RuntimeException exception = LottoPurchaseException.purchaseMoneyTooSmall();

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE).contains(exception.getMessage());
        });
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1001", "1002", "1003"})
    void 로또_구입_금액이_1000원_단위가_아닌_경우(String input) {

        RuntimeException exception = LottoPurchaseException.purchaseMoneyNotDividable();

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE).contains(exception.getMessage());
        });
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,8", "1,2,3,4,5,6,8,9"})
    void 당첨_번호가_6개가_아닌_경우(String input) {

        RuntimeException exception = WinningLottoException.invalidWinningNumberSize();

        assertSimpleTest(() -> {
            runException(validPurchaseMoneyInput, input, validBonusNumberInput);
            assertThat(output()).contains(ERROR_MESSAGE).contains(exception.getMessage());
        });
    }

    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5,5", "1,2,3,3,4,5"})
    void 당첨_번호가_중복된_경우(String input) {

        RuntimeException exception = WinningLottoException.duplicateWinningNumbers();

        assertSimpleTest(() -> {
            runException(validPurchaseMoneyInput, input, validBonusNumberInput);
            assertThat(output()).contains(ERROR_MESSAGE).contains(exception.getMessage());
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
