package oncall.handler;

import oncall.constants.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidatorImpl implements InputValidator {

    private static final String DATE_INFO_REGEX = "^\\d+,[ㄱ-ㅎ가-힣]+$";
    private static final String WORKER_SCHEDULE_REGEX = "^ㄱ-ㅎ가-힣(,ㄱ-ㅎ가-힣)*$";


    @Override
    public void validateDateInfo(String string) {
        if (!string.matches(DATE_INFO_REGEX)) {
            throw new IllegalArgumentException(Errors.NOT_VALID_DATE_INPUT.getMessage());
        }
    }

    @Override
    public void validateWorkSchedule(String string) {
        if (!string.matches(WORKER_SCHEDULE_REGEX)) {
            throw new IllegalArgumentException(Errors.NOT_VALID_DATE_INPUT.getMessage());
        }
    }

    @Override
    public Pattern getDateInfoPattern() {
        return Pattern.compile(DATE_INFO_REGEX);
    }

    @Override
    public Pattern getWorkSchedulePattern() {
        return Pattern.compile(WORKER_SCHEDULE_REGEX);
    }
}
