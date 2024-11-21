package oncall.dto;

public record MatchedWorkDto(
        int month,
        int monthDay,
        String koreanWeekDay,
        boolean restDay,
        boolean holiday,
        String worker
) {
}
