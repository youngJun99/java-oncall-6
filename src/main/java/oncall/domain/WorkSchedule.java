package oncall.domain;

import oncall.constants.Errors;
import oncall.domain.vo.Worker;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WorkSchedule {

    private static final int MIN_WORKERS = 5;
    private static final int MAX_WORKERS = 35;


    private final Queue<Worker> workSchedule = new LinkedList<>();
    private final Queue<Worker> changedSchedule = new LinkedList<>();

    public WorkSchedule(List<Worker> workers) {
        validateNumberOfWorkers(workers);
        validateDuplicateName(workers);
        workSchedule.addAll(workers);
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
