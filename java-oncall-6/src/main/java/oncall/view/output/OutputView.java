package oncall.view.output;

import java.util.List;
import oncall.model.response.WorkerSchedule;
import oncall.view.response.ModelResponse;

public interface OutputView {

    void output(final ModelResponse response);

    void printWorkerSchedules(final List<WorkerSchedule> response);
}
