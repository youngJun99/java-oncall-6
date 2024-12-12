package oncall.view;

import oncall.dto.WorkScheduleDto;

import java.util.List;

public class OutputView {

    private static final String printFormat = "%d월 %d일 %s%s %s";
    private static final String NONE_WEEK_END_REST_DAY = "휴일";

    public void printSchedule(List<WorkScheduleDto> workScheduleDtos) {
        workScheduleDtos.forEach(workSchedule-> {
            if(workSchedule.notWeekEndRestDay()) {
                printSchedule(workSchedule, NONE_WEEK_END_REST_DAY);
                return;
            }
            printSchedule(workSchedule, "");
        });

    }

    private static void printSchedule(WorkScheduleDto workSchedule, String x) {
        System.out.println(String.format(printFormat,
                workSchedule.month(),
                workSchedule.day(),
                workSchedule.dayOfWeek().name(),
                x,
                workSchedule.worker().getName()));
    }
}
