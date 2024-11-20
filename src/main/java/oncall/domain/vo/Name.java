package oncall.domain.vo;

import jdk.jshell.ErroneousSnippet;
import oncall.constants.Errors;

public class Name {

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException(Errors.NAME_RANGE_ERROR.getMessage());
        }
    }
}
