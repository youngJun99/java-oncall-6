package oncall.handler;

import java.util.regex.Matcher;

public interface InputValidator {

    void validateDateInfo(String string);

    void validateWorkSchedule(String string);

    Matcher getMatcher();
}
