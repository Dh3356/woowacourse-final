package oncall.view.input;

import java.util.List;
import java.util.Map.Entry;

public interface InputView {

    int input();

    Entry<Integer, String> inputSchedule();

    List<String> inputWeekDayWorkers();

    List<String> inputWeekEndWorkers();
}
