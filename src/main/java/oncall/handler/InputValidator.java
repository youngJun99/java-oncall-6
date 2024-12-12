package oncall.handler;

import oncall.constants.DayOfWeek;
import oncall.constants.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {


    public static final String MONTH_AND_DAY_OF_WEEK_REGEX = "(^\\d+),([가-힣]+)";
    private static final String WORKERS_REGEX = "^[가-힣]+(,[가-힣]+)*$";

    public void validateMonthAndDayInput(String input) {
        Pattern pattern = Pattern.compile(MONTH_AND_DAY_OF_WEEK_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches() || !DayOfWeek.isInDayOfWeek(matcher.group(2))) {
            throw new IllegalArgumentException(Errors.NO_SUCH_DAY_OF_WEEK.getMessage());
        }
        if (!input.matches(MONTH_AND_DAY_OF_WEEK_REGEX)) {
            throw new IllegalArgumentException(Errors.INVALID_DATE_INFO_INPUT.getMessage());
        }
    }

    public void validateWorkersInput(String input) {
        if (!input.matches(WORKERS_REGEX)) {
            throw new IllegalArgumentException(Errors.INVALID_WORKER_INPUT.getMessage());
        }
    }
}
