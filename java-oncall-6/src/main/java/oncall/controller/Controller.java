package oncall.controller;

import java.util.List;
import java.util.Map.Entry;
import oncall.controller.retryer.Retryer;
import oncall.model.Schedule;
import oncall.model.Worker;
import oncall.model.policy.DayOffPolicy;
import oncall.model.response.WorkerSchedule;
import oncall.view.input.InputView;
import oncall.view.output.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    private final DayOffPolicy dayOffPolicy;

    public Controller(InputView inputView, OutputView outputView, DayOffPolicy dayOffPolicy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dayOffPolicy = dayOffPolicy;
    }

    public void run() {
        Schedule schedule = Retryer.retryOnCustomException(this::getSchedule);

        List<Worker> weekDayWorkersInput = Retryer.retryOnCustomException(inputView::inputWeekDayWorkers).stream()
                .map(Worker::from)
                .toList();
        List<Worker> weekEndWorkersInput = Retryer.retryOnCustomException(inputView::inputWeekEndWorkers).stream()
                .map(Worker::from)
                .toList();
        List<WorkerSchedule> response = schedule.getWorkerSchedules(weekDayWorkersInput, weekEndWorkersInput,
                dayOffPolicy);

        outputView.printWorkerSchedules(response);
    }

    private Schedule getSchedule() {
        Entry<Integer, String> scheduleInput = Retryer.retryOnCustomException(inputView::inputSchedule);
        return Schedule.of(scheduleInput.getKey(), scheduleInput.getValue());
    }
}
