package oncall.handler;

import oncall.dto.StartDateDto;
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

    public StartDateDto getDateInfo() {
        String dateInfo = inputView.getInputDate();
        inputValidator.validateDateInfo(dateInfo);
        Matcher matcher = inputValidator.getDateInfoPattern().matcher(dateInfo);
        matcher.matches();
        int month = Integer.parseInt(matcher.group(1));
        String koreanWeekDay = matcher.group(2);
        return new StartDateDto(month, koreanWeekDay);
    }

    public List<String> getWorkDayWorkSchedule() {
        String schedule = inputView.getWeekDayWorkSchedule();
        return makeScheduleList(schedule);
    }

    public List<String> getRestDayWorkSchedule() {
        String schedule = inputView.getRestDayWorkSchedule();
        return makeScheduleList(schedule);
    }

    private List<String> makeScheduleList(String schedule) {
        inputValidator.validateWorkSchedule(schedule);

        String[] workersArray = schedule.split(","); // 쉼표로 분리

        List<String> workers = new ArrayList<>();
        for (String worker : workersArray) {
            workers.add(worker.trim());
        }
        return workers;
    }
}
