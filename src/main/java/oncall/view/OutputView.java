package oncall.view;

import oncall.dto.MatchedWorkDto;

import java.util.List;

public class OutputView {

    private final static String REST_DAY_STRING = "(휴일) ";

    public void printResult(List<MatchedWorkDto> workSchedule) {
        workSchedule.forEach(day -> {
            System.out.println(day.month() + "월 " +
                    day.monthDay() + "일 " +
                    day.koreanWeekDay() + " " +
                    restDayFormat(day.restDay()) +
                    day.worker()
            );
        });
    }

    private String restDayFormat(boolean restDay) {
        if (restDay) {
            return REST_DAY_STRING;
        }
        return "";
    }

}
