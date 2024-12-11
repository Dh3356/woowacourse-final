package oncall.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import oncall.model.policy.DayOffPolicy;
import oncall.model.response.WorkerSchedule;

public class Schedule {

    private final Month month;
    private final DayOfWeek startDay;

    public Schedule(final Month month, final DayOfWeek startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public static Schedule of(final int month, final String startDay) {
        return new Schedule(Month.from(month), DayOfWeek.from(startDay));
    }

    public List<WorkerSchedule> getWorkerSchedules(
            final List<Worker> weekDayWorkers,
            final List<Worker> weekEndWorkers,
            final DayOffPolicy dayOffPolicy) {

        validateWorkers(weekDayWorkers, weekEndWorkers);

        Deque<Worker> weekDayWorkersDeque = new LinkedList<>(weekDayWorkers);
        Deque<Worker> weekEndWorkersDeque = new LinkedList<>(weekEndWorkers);
        List<WorkerSchedule> workerSchedules = new ArrayList<>();
        DayOfWeek dayOfWeek = startDay;
        for (int day = 1; day <= month.getLength(); day++) {

            Worker worker = pollWorker(weekDayWorkersDeque, weekEndWorkersDeque, dayOffPolicy, day, dayOfWeek);
            workerSchedules.add(
                    new WorkerSchedule(month, day, dayOfWeek, worker, dayOffPolicy.isDayOff(month, day, dayOfWeek)));

            swapIfSequential(worker, weekDayWorkersDeque, weekEndWorkersDeque, dayOffPolicy, day, dayOfWeek);
            dayOfWeek = dayOfWeek.next();
        }
        return workerSchedules;
    }

    private Worker pollWorker(
            final Deque<Worker> weekDayWorkers,
            final Deque<Worker> weekEndWorkers,
            final DayOffPolicy dayOffPolicy,
            final int day,
            final DayOfWeek dayOfWeek) {

        if (dayOffPolicy.isDayOff(month, day, dayOfWeek)) {
            Worker worker = weekEndWorkers.pollFirst();
            weekEndWorkers.addLast(worker);
            return worker;
        }
        Worker worker = weekDayWorkers.pollFirst();
        weekDayWorkers.addLast(worker);
        return worker;
    }

    private Worker peekWorker(
            final Deque<Worker> weekDayWorkers,
            final Deque<Worker> weekEndWorkers,
            final DayOffPolicy dayOffPolicy,
            final int day,
            final DayOfWeek dayOfWeek) {

        if (dayOffPolicy.isDayOff(month, day, dayOfWeek)) {
            return weekEndWorkers.peekFirst();
        }
        return weekDayWorkers.peekFirst();
    }

    private void swapIfSequential(
            final Worker worker,
            final Deque<Worker> weekDayWorkers,
            final Deque<Worker> weekEndWorkers,
            final DayOffPolicy dayOffPolicy,
            final int day,
            final DayOfWeek dayOfWeek) {

        Worker nextWorker = peekWorker(weekDayWorkers, weekEndWorkers, dayOffPolicy, day + 1, dayOfWeek.next());

        if (worker.equals(nextWorker)) {
            if (dayOffPolicy.isDayOff(month, day + 1, dayOfWeek.next())) {
                swap(weekEndWorkers);
            } else {
                swap(weekDayWorkers);
            }
        }
    }

    private void swap(final Deque<Worker> workers) {
        Worker firstWorker = workers.pollFirst();
        Worker secondWorker = workers.pollFirst();
        workers.addFirst(firstWorker);
        workers.addFirst(secondWorker);
    }

    private void validateWorkers(final List<Worker> weekDayWorkers, final List<Worker> weekEndWorkers) {
        if (Set.copyOf(weekDayWorkers).size() != weekDayWorkers.size()) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        if (Set.copyOf(weekEndWorkers).size() != weekEndWorkers.size()) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        if (!Set.copyOf(weekDayWorkers).containsAll(weekEndWorkers) ||
                !Set.copyOf(weekEndWorkers).containsAll(weekDayWorkers)) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "month=" + month +
                ", startDay=" + startDay +
                '}';
    }
}
