package oncall.domain;

import oncall.constants.Errors;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Workers {

    private static final int WORKER_LENGTH_UPPER_LIMIT = 35;
    private static final int WORKER_LENGTH_LOWER_LIMIT = 5;

    private final LinkedList<Worker> workers;

    public Workers(List<String> workers) {
        validateDuplicate(workers);
        validateLength(workers);
        this.workers = workers.stream()
                .map(Worker::new)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Worker getFirstWorker() {
        Worker nextWorker = workers.removeFirst();
        workers.add(nextWorker);
        return nextWorker;
    }

    public Worker getNextWorker(Worker previousWorker) {
        Worker nextWorker = workers.removeFirst();
        if (nextWorker.equals(previousWorker)) {
            Worker changedWorker = workers.removeFirst();
            workers.addFirst(nextWorker);
            workers.add(changedWorker);
            return changedWorker;
        }
        workers.add(nextWorker);
        return nextWorker;
    }


    private void validateDuplicate(List<String> workers) {
        if (workers.size() != workers.stream().distinct().count()) {
            throw new IllegalArgumentException(Errors.DUPLICATE_WORKERS.getMessage());
        }
    }

    private void validateLength(List<String> workers) {
        if (workers.size() < WORKER_LENGTH_LOWER_LIMIT || workers.size() > WORKER_LENGTH_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(Errors.WORKERS_RANGE.getMessage(), WORKER_LENGTH_LOWER_LIMIT, WORKER_LENGTH_UPPER_LIMIT));
        }
    }

}
