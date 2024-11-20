package oncall.domain;

import oncall.constants.Errors;
import oncall.domain.vo.Worker;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WorkSchedule {

    private static final int MIN_WORKERS = 5;
    private static final int MAX_WORKERS = 35;


    private final Queue<Worker> workSchedule;
    private final Queue<Worker> changedSchedule;
    private int changed;

    public WorkSchedule(List<Worker> workers) {
        validateNumberOfWorkers(workers);
        validateDuplicateName(workers);
        workSchedule = new LinkedList<>();
        changedSchedule = new LinkedList<>();
        changed = 0;
        workSchedule.addAll(workers);
    }

    public Worker getFirstWorker() {
        Worker workerToReturn = workSchedule.poll();
        workSchedule.add(workerToReturn);
        return workerToReturn;
    }

    public Worker getNextWorker(Worker currentWorker) {
        if (changedSchedule.isEmpty()) {
            return ProcessNormalOrder(currentWorker);
        }
        return ProcessChangedOrder(currentWorker);
    }

    private Worker ProcessChangedOrder(Worker currentWorker) {
        if (currentWorker.equals(changedSchedule.peek())) {
            changed++;
            Worker workerToReturn = workSchedule.poll();
            changedSchedule.add(workerToReturn);
            return workerToReturn;
        }
        Worker workerToReturn = changedSchedule.poll();
        workSchedule.add(workerToReturn);
        while (changed != 0) {
            workSchedule.add(changedSchedule.poll());
        }
        return workerToReturn;
    }

    private Worker ProcessNormalOrder(Worker currentWorker) {
        if (currentWorker.equals(workSchedule.peek())) {
            changed++;
            changedSchedule.add(workSchedule.poll());
            Worker workerToReturn = workSchedule.poll();
            changedSchedule.add(workerToReturn);
            return workerToReturn;
        }
        Worker workerToReturn = workSchedule.poll();
        workSchedule.add(workerToReturn);
        return workerToReturn;
    }

    private void validateNumberOfWorkers(List<Worker> inputWorkers) {
        if (inputWorkers.size() < MIN_WORKERS || inputWorkers.size() > MAX_WORKERS) {
            throw new IllegalArgumentException(String.format(Errors.WORKER_NUMBER_RANGE.getMessage(), MIN_WORKERS, MAX_WORKERS));
        }
    }

    private void validateDuplicateName(List<Worker> inputWorkers) {
        boolean duplicateExist = inputWorkers.stream()
                .distinct()
                .count() != inputWorkers.size();
        if (duplicateExist) {
            throw new IllegalArgumentException(Errors.DUPLICATE_NAME.getMessage());
        }
    }
}
