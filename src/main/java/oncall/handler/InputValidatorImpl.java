package oncall.handler;

import oncall.constants.Errors;

import java.util.regex.Matcher;

public class InputValidatorImpl implements InputValidator {

    private static final String DATE_INFO_REGEX = "^₩d,₩d$";
    private static final String WORKER_SCHEDULE_REGEX = "^ㄱ-ㅎ가-힣(,ㄱ-ㅎ가-힣)*$";


    @Override
    public void validateDateInfo(String string) {
        if (!string.matches(DATE_INFO_REGEX)) {
            throw new IllegalArgumentException(Errors.NOT_VALID_DATE_INPUT.getMessage());
        }
    }

    @Override
    public void validateWorkSchedule(String string) {

    }

    @Override
    public Matcher getDateInfoMatcher() {
        return null;
    }

    @Override
    public Matcher getWorkScheduleMatcher() {
        return null;
    }
}
