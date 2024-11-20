package oncall.handler;

import oncall.dto.DateDto;
import oncall.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class InputHandler {

    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputHandler(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public DateDto getDateInfo() {
        String dateInfo = inputView.getInputDate();
        inputValidator.validateDateInfo(dateInfo);
        Matcher matcher = inputValidator.getDateInfoPattern().matcher(dateInfo);
        int month = Integer.parseInt(matcher.group(1));
        String koreanWeekDay = matcher.group(2);
        return new DateDto(month, koreanWeekDay);
    }

    public List<String> getWeekDayWorkSchedule() {
        String schedule = inputView.getWeekDayWorkSchedule();
        return makeScheduleList(schedule);
    }

    public List<String> getWeekEndsWorkSchedule() {
        String schedule = inputView.getWeekEndWorkSchedule();
        return makeScheduleList(schedule);
    }

    private List<String> makeScheduleList(String schedule) {
        inputValidator.validateWorkSchedule(schedule);
        Matcher matcher = inputValidator.getWorkSchedulePattern().matcher(schedule);
        List<String> workers = new ArrayList<>();
        while (matcher.find()) {
            workers.add(matcher.group(1));
        }
        return workers;
    }
}
