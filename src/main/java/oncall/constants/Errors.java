package oncall.constants;

public enum Errors {

    MONTH_NOT_VALID("월을 잘못 입력했습니다"),

    MONTH_DAY_NOT_VALID("일자를 잘못 입력했습니다"),

    DATE_NOT_VALID("존재할 수 없는 날짜입니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
