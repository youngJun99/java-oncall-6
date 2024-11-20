package oncall.domain.vo;

import oncall.constants.Errors;

import java.util.Objects;

public class Worker {

    private final String name;

    public Worker(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException(Errors.NAME_RANGE_ERROR.getMessage());
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
