package oncall.view;

import oncall.dto.WorkSchedule;

import java.util.List;

public class OutputView {

    private static final String CALENDER_FORMAT = "%d월 %d일 %s%s %s";
    private static final String NON_WEEKEND_HOLIDAY = "(휴일)";

    public void printWorkerCalender(List<WorkSchedule> calender) {
        calender.forEach(workSchedule -> {
            System.out.println(String.format(CALENDER_FORMAT,
                    workSchedule.month(),
                    workSchedule.day(),
                    workSchedule.weekDay(),
                    printNonWeekendHolidayMark(workSchedule.isNoneWeekendHoliday()),
                    workSchedule.workerName()));
        });
    }
    private String printNonWeekendHolidayMark(boolean isHoliday) {
        if (isHoliday) {
            return NON_WEEKEND_HOLIDAY;
        }
        return "";
    }
}
