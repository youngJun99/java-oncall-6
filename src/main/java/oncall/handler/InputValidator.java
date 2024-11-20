package oncall.handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface InputValidator {

    void validateDateInfo(String string);

    void validateWorkSchedule(String string);

    Pattern getDateInfoPattern();

    Pattern getWorkSchedulePattern();
}
