package oncall.constants;

public enum Errors {

    //재시도 횟수 관련 에러
    OVER_MAX_RETRIES("최대 재시도 횟수 %d번을 초과했습니다."),

    //직원 관련 에러
    WORKER_NAME_LENGTH("직원의 이름은 %d글자를 넘어가면 안됩니다."),
    DUPLICATE_WORKERS("한 근무표에 중복된 직원이 존재합니다."),
    WORKERS_LENGTH("직원은 최소 %d명 최대 %d명 사이를 입력해야 합니다."),
    INVALID_WORKER_INPUT("직원의 입력 형식이 올바르지 않습니다."),

    //날짜 관련 에러
    NO_SUCH_DAY_OF_WEEK("존재하지 않는 요일입니다."),
    MONTH_RANGE("월은 %d 부터 %d 사이로 입력해주세요."),
    INVALID_DATE_INFO_INPUT("날짜와 요일을 올바르게 입력하지 않았습니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
