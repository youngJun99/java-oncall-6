package oncall.constants;

import java.util.Arrays;
import java.util.List;

public enum DayOfWeek {
    월,
    화,
    수,
    목,
    금,
    토,
    일;

    private static final List<Integer> WeekEndIndex = List.of(5,6);

    public static DayOfWeek of(String name) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.name().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(Errors.NO_SUCH_DAY_OF_WEEK.getMessage()));
    }

    public static boolean isWeekEnd(DayOfWeek dayOfWeek){
        return WeekEndIndex.contains(dayOfWeek.ordinal());
    }

    public static boolean isInDayOfWeek(String name) {
        return Arrays.stream(DayOfWeek.values())
                .anyMatch(dayOfWeek -> dayOfWeek.name().equals(name));
    }

    public static DayOfWeek getNextDayOfWeek(DayOfWeek inputDayOfWeek) {
            if(inputDayOfWeek.equals(일)) {
                return 월;
            }
            return DayOfWeek.values()[inputDayOfWeek.ordinal() + 1];
    }

}


