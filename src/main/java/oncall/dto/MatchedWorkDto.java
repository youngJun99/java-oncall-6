package oncall.dto;

public record MatchedWorkDto(
        int month,
        int monthDay,
        String koreanWeekDay,
        boolean restDay,
        String worker
) {
}
