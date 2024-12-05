package oncall.constants;

import oncall.domain.Date;

import java.util.Arrays;

public enum Holiday {
    산정(1, 1),
    삼일절(3, 1),
    어린이날(5, 5),
    현충일(6, 6),
    광복절(8, 15),
    개천절(10, 3),
    한글날(10, 9),
    성탄절(12, 25);

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(Date date) {
        int inputMonth = date.getMonth();
        int inputDay = date.getDay();
        return Arrays.stream(Holiday.values())
                .anyMatch(holiday -> holiday.month == inputMonth && holiday.day == inputDay);
    }
}
