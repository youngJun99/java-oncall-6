package oncall.domain;

import oncall.constants.Errors;

import java.util.Objects;

public class Worker {

    private static final int NAME_LIMIT = 5;

    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String inputName) {
        if(inputName.length() > NAME_LIMIT) {
            throw new IllegalArgumentException(String.format(Errors.WORKER_NAME_LENGTH.getMessage(),NAME_LIMIT));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Worker worker = (Worker) object;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

