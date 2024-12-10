package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Application 테스트")
class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
