package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.view.exception.InvalidInputException;

public class ConsoleInputView implements InputView {

    @Override
    public int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidPurchaseMoney();
        }
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        } catch (RuntimeException e) {
            throw InvalidInputException.invalidWinningNumber();
        }
    }

    @Override
    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidBonusNumber();
        }
    }
}
