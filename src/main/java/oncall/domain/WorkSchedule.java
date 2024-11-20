package oncall.domain;

import oncall.constants.Errors;
import oncall.domain.vo.Worker;

import java.util.List;
import java.util.Queue;

public class WorkSchedule {

    private static final int MIN_WORKERS = 5;
    private static final int MAX_WORKERS = 35;


    private final Queue<Worker> workSchedule;
    private final Queue<Worker> changedSchedule;

    public WorkSchedule(List<Worker> workers) {
        validateNumberOfWorkers(workers);

    }

    private void validateNumberOfWorkers(List<Worker> inputWorkers) {
        if (inputWorkers.size() < MIN_WORKERS || inputWorkers.size() > MAX_WORKERS) {
            throw new IllegalArgumentException(String.format(Errors.WORKER_NUMBER_RANGE_ERROR.getMessage(),MIN_WORKERS,MAX_WORKERS));
        }
    }
}
