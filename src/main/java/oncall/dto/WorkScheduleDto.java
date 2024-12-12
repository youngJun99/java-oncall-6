package oncall.dto;

import oncall.constants.DayOfWeek;
import oncall.domain.Worker;

public record WorkScheduleDto(
        int month,
        int day,
        DayOfWeek dayOfWeek,
        boolean notWeekEndRestDay,
        Worker worker
) {
}


