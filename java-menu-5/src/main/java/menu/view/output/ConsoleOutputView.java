package menu.view.output;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }
}
