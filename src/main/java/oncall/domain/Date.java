package oncall.domain;

import oncall.constants.DayOfWeek;
import oncall.constants.Errors;
import oncall.constants.Holiday;

import java.util.List;

public class Date {

    private static final int DECEMBER = 12;
    private static final int JANUARY = 1;
    private static final int START_OF_MONTH = 1;

    private final int month;
    private int day;
    private final int lastDayOfMonth;
    private DayOfWeek dayOfWeek;

    public Date(int month, DayOfWeek dayOfWeek) {
        validateMonthRange(month);
        this.month = month;
        this.day = START_OF_MONTH;
        this.lastDayOfMonth = getLastDayOfMonth(month);
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isRestDay() {
        return DayOfWeek.isWeekEnd(dayOfWeek) || Holiday.isHoliday(month,day);
    }

    public void toNextDay() {
        day++;
        this.dayOfWeek = DayOfWeek.getNextDayOfWeek(dayOfWeek);
    }

    public boolean needNextEmergencyWorker() {
        return day <= lastDayOfMonth;
    }


    private void validateMonthRange(int month) {
        if(month < JANUARY || month > DECEMBER) {
            throw new IllegalArgumentException(String.format(Errors.MONTH_RANGE.getMessage(),JANUARY,DECEMBER));
        }
    }

    private int getLastDayOfMonth(int month) {
        if(month == 2) {
            return 28;
        }
        if(List.of(4,5,9,11).contains(month)){
            return 30;
        }
        return 31;
    }
}



