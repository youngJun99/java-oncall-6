package oncall.domain.vo;

import oncall.constants.Errors;

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
}
