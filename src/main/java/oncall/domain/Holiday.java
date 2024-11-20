package oncall.domain;

import java.util.Arrays;

public enum Holiday {
    신정(1, 1),
    삼일절(3, 1),
    어린이날(5, 5),
    현충일(6, 6),
    광복절(8, 15),
    개천절(10, 3),
    한글날(10, 9),
    성탄절(12, 25);

    private int month;
    private int monthDay;

    Holiday(int month, int monthDay) {
        this.month = month;
        this.monthDay = monthDay;
    }

    public static boolean isHoliday(int inputMonth, int inputMonthDay) {
        return Arrays.stream(Holiday.values())
                .anyMatch(holiday -> holiday.month == inputMonth && holiday.monthDay == inputMonthDay);
    }
}
