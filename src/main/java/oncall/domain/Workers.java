package oncall.domain;

import oncall.constants.Errors;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Workers {

    private static final int WORKERS_RANGE_UPPER_LIMIT = 35;
    private static final int WORKERS_RANGE_LOWER_LIMIT = 5;

    private final LinkedList<Worker> workers;

    public Workers(List<String> workers) {
        validateLength(workers);
        validateDuplicate(workers);
        this.workers = workers.stream()
                .map(Worker::new)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Worker getFirstWorker() {
        Worker worker = workers.poll();
        workers.add(worker);
        return worker;
    }

    public Worker getNextWorker(Worker previousWorker) {
        Worker nextWorker = workers.poll();
        if (previousWorker.equals(nextWorker)) {
            Worker changedWorker = workers.poll();
            workers.addFirst(nextWorker);
            workers.add(changedWorker);
            return changedWorker;
        }
        return getFirstWorker();
    }

    private void validateLength(List<String> workers) {
        if (workers.size() < WORKERS_RANGE_LOWER_LIMIT || workers.size() > WORKERS_RANGE_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(Errors.WORKERS_LENGTH.getMessage(), WORKERS_RANGE_LOWER_LIMIT, WORKERS_RANGE_UPPER_LIMIT));
        }
    }

    private void validateDuplicate(List<String> workers) {
        if (workers.size() != workers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(Errors.DUPLICATE_WORKERS.getMessage());
        }
    }
}




