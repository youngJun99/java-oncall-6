package oncall.vo;

import oncall.constants.Errors;

public class MyMonth {

    private final int month;

    public MyMonth(int month) {
        validateMyMonth(month);
        this.month = month;
    }

    private void validateMyMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(Errors.MONTH_NOT_VALID.getMessage());
        }
    }

    public int getMonth() {
        return month;
    }

}
