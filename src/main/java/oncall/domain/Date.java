package oncall.domain;

import oncall.constants.DayOfWeek;
import oncall.constants.Errors;

import java.util.List;

public class Date {

    private final int month;
    private int day;
    private DayOfWeek dayOfWeek;
    private final int endDateOfMonth;

    public Date(int month, String dayOfWeek) {
        validateMonth(month);
        this.month = month;
        this.dayOfWeek = DayOfWeek.of(dayOfWeek);
        this.day = 1;
        this.endDateOfMonth = getEndDateOfMonth(month);
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek.getName();
    }

    public boolean isWorkDay() {
        return dayOfWeek.isWorkDay();
    }

    public boolean hasNextDay() {
        return (day + 1) <= endDateOfMonth;
    }

    public void nextDay() {
        this.day++;
        this.dayOfWeek = DayOfWeek.getNextDayOfWeek(dayOfWeek);
    }

    private void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(Errors.MONTH_RANGE.getMessage());
        }
    }

    private int getEndDateOfMonth(int month) {
        if (month == 2) {
            return 28;
        }
        if (List.of(1, 3, 5, 7, 8, 10, 12).contains(month)) {
            return 31;
        }
        return 30;
    }

}
