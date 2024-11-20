package oncall.domain.vo;

import oncall.constants.Errors;

public class MyMonthDay {

    private int monthDay;

    public MyMonthDay(int monthDay) {
        validateMonthDay(monthDay);
        this.monthDay = monthDay;
    }

    public int getMonthDay() {
        return monthDay;
    }

    private void validateMonthDay(int monthDay) {
        if(monthDay < 1 || monthDay > 32) {
            throw new IllegalArgumentException(Errors.MONTH_DAY_OUT_OF_RANGE.getMessage());
        }
    }
}
