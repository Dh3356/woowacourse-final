package oncall.view.output;

import java.util.List;
import oncall.model.response.WorkerSchedule;
import oncall.view.response.ModelResponse;

public class ConsoleOutputView implements OutputView {


    @Override
    public void printWorkerSchedules(final List<WorkerSchedule> response) {
        System.out.println();
        response.forEach(this::printWorkerSchedule);
    }

    private void printWorkerSchedule(final WorkerSchedule response) {
        int month = response.month().getValue();
        int day = response.day();
        String dayOfWeek = response.dayOfWeek().getName();
        String workerNickName = response.worker().getNickName();
        boolean isDayOff = response.isDayOff();

        System.out.printf("%d월 %d일 %s %s" + System.lineSeparator(), month, day, dayOfWeek, workerNickName);
    }


    @Override
    public void output(final ModelResponse response) {
        System.out.print(response.getData());
    }


    private String formatToWon(final int value) {
        return String.format("%,d", value);
    }
}
