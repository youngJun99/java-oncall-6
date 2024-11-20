package oncall.constants;

public enum Errors {

    MONTH_OUT_OF_RANGE("월의 입력범위 오류"),

    MONTH_DAY_OUT_OF_RANGE("일자 입력 범위 오류"),

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
