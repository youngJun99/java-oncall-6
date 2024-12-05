package oncall.handler;

import oncall.constants.Errors;

public class InputValidator {

    private static final String DATE_INPUT_REGEX = "^\\d+,(월|화|수|목|금|토|일)$";
    private static final String WORKER_INPUT_REGEX = "^([가-힣]+)(,([가-힣]+))*$";

    public void validateDateInput(String input) {
        if (!input.matches(DATE_INPUT_REGEX)) {
            throw new IllegalArgumentException(Errors.DATE_INPUT.getMessage());
        }
    }

    public void validateWorkersInput(String input) {
        if (!input.matches(WORKER_INPUT_REGEX)) {
            throw new IllegalArgumentException(Errors.INVALID_WORKER_INPUT.getMessage());
        }
    }
}



