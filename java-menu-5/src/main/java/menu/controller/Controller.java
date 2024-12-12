package menu.controller;

import menu.view.output.OutputView;

public class Controller {

    private final OutputView outputView;

    public Controller(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
    }
}
