package oncall.constants;

public enum Errors {

    //시스템 에러
    SYSTEM_ERROR("시스템 구조 에러"),

    //날짜 입력관련 에러
    MONTH_OUT_OF_RANGE("월의 입력범위 오류"),
    MONTH_DAY_OUT_OF_RANGE("일자 입력 범위 오류"),
    DATE_NOT_VALID("존재할 수 없는 날짜입니다"),
    WEEK_DAY_NOT_VALID("요일을 올바르게 입력하지 않았습니다"),

    //근무자 입력관련 에러
    NAME_RANGE_ERROR("이름이 5글자 이상입니다."),
    WORKER_NUMBER_RANGE_ERROR("근무자는 %d명 이상 %d명 이하여야 합니다");




    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
