package oncall.domain;

import oncall.constants.Errors;

import java.util.Arrays;

public enum KoreanWeekDay {
    월요일(1, "월"),
    화요일(2, "화"),
    수요일(3, "수"),
    목요일(4, "목"),
    금요일(5, "금"),
    토요일(6, "토"),
    일요일(7, "일");

    private int dayIndex;
    private String name;

    KoreanWeekDay(int dayIndex, String name) {
        this.dayIndex = dayIndex;
        this.name = name;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public String getName() {
        return name;
    }

    public static int getIndexOf(String input) {
        return Arrays.stream(KoreanWeekDay.values())
                .filter(weekday -> weekday.name.equals(input))
                .mapToInt(weekday -> weekday.dayIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Errors.WEEK_DAY_NOT_VALID.getMessage()));
    }

    public static String getNameOf(int day) {
        int index = processDayToIndex(day);
        return Arrays.stream(KoreanWeekDay.values())
                .filter(weekday -> weekday.dayIndex == index)
                .map(weekday -> weekday.name)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Errors.SYSTEM_ERROR.getMessage()));
    }

    private static int processDayToIndex(int day) {
        if (day % 7 == 0) {
            return 7;
        }
        return day % 7;
    }

}
