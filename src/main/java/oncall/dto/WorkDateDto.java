package oncall.dto;

public record WorkDateDto(
        int month,
        int monthDay,
        String koreanWeekDay,
        boolean restDay
) {
}
