package oncall.constants;

public enum Errors {

    //시스템 에러
    SYSTEM_ERROR("시스템 구조 에러"),

    //입력 횟수 관련 에러
    OVER_MAX_RETRIES("재시도 횟수를 초과했습니다"),

    //날짜 입력관련 에러
    MONTH_OUT_OF_RANGE("월의 입력범위 오류"),
    WEEK_DAY_NOT_VALID("요일을 올바르게 입력하지 않았습니다"),
    NOT_VALID_DATE_INPUT("날짜의 입력 형식이 올바르지 않습니다."),

    //근무자 입력관련 에러NOT_VALID_WORKERS_INPUT("근문자 입력 형식이 올바르지 않습니다"),
    NAME_RANGE("이름이 5글자 이상입니다."),
    DUPLICATE_NAME("근무자 이름이 중복됩니다."),
    WORKER_NUMBER_RANGE("근무자는 %d명 이상 %d명 이하여야 합니다"),;




    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
