package oncall.dto;

public record WorkSchedule(
        int month,
        int day,
        String weekDay,
        String workerName,
        boolean isNoneWeekendHoliday
) {
}
