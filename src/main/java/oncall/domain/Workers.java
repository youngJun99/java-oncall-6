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
    }


    private void validateLength(List<String> workers) {
        if(workers.size() < WORKERS_RANGE_LOWER_LIMIT || workers.size() > WORKERS_RANGE_UPPER_LIMIT){
            throw new IllegalArgumentException(String.format(Errors.WORKERS_LENGTH.getMessage(),WORKERS_RANGE_LOWER_LIMIT,WORKERS_RANGE_UPPER_LIMIT));
        }
    }

    private void validateDuplicate(List<String> workers) {
        if(workers.size() != workers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(Errors.DUPLICATE_WORKERS.getMessage());
        }
    }
}



-[ ] 근무로직 추가 필요 !!
        -[ ] 전의 근무자를 받는 경우와 안받는 경우를 따로 2개로 만들자.
