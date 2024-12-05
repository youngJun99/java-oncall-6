package oncall.constants;

public enum Errors {

    //도메인 관련 에러
    //사원 관련
    WORKER_NAME_RANGE("사원의 이름은 %d 글자 이하여야 합니다."),
    WORKERS_RANGE("순번을 구성하는 사원은 최소 %d명 이상 최대 %d명 이하여야 합니다."),
    INVALID_WORKER_INPUT("사원들의 입력 형식이 올바르지 않습니다."),
    DUPLICATE_WORKERS("순번에 중복된 사원이 존재합니다."),

    //날짜 관련
    MONTH_RANGE("월은 1월 부터 12월 사이를 입력해야 합니다."),
    DATE_INPUT("요일의 입력 형식이 올바르지 않습니다..");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
