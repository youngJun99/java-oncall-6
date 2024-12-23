package oncall.domain.vo;

import oncall.constants.Errors;

public class MyMonth {

    private int month;

    public MyMonth(int month) {
        validateMyMonth(month);
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    private void validateMyMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(Errors.MONTH_OUT_OF_RANGE.getMessage());
        }
    }

}
