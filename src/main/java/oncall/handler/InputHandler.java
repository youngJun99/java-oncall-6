package oncall.handler;

import oncall.constants.DayOfWeek;
import oncall.domain.Date;
import oncall.domain.Workers;
import oncall.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static oncall.handler.InputValidator.MONTH_AND_DAY_OF_WEEK_REGEX;

public class InputHandler {

    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputHandler(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public Date getDateInformation() {
        String input = inputView.getMonthAndDayOfWeek();
        inputValidator.validateMonthAndDayInput(input);
        Pattern pattern = Pattern.compile(MONTH_AND_DAY_OF_WEEK_REGEX);
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        int month = Integer.parseInt(matcher.group(1));
        DayOfWeek dayOfWeek = DayOfWeek.of(matcher.group(2));
        return new Date(month,dayOfWeek);
    }

    public Workers getWeekDayWorkers() {
        String input = inputView.getWeekDayWorkers();
        inputValidator.validateWorkersInput(input);
        return new Workers(new ArrayList<>(List.of(input.split(","))));
    }

    public Workers getWeekEndWorkers() {
        String input = inputView.getWeekEndWorkers();
        inputValidator.validateWorkersInput(input);
        return new Workers(new ArrayList<>(List.of(input.split(","))));
    }
}
