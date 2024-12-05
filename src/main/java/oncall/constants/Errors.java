package oncall.constants;

public enum Errors {

    //도메인 관련 에러
    //사원 관련
    WORKER_NAME_RANGE("사원의 이름은 %d 글자 이하여야 합니다."),
    WORKERS_RANGE("순번을 구성하는 사원은 최소 %d명 이상 최대 %d명 이하여야 합니다."),
    DUPLICATE_WORKERS("순번에 중복된 사원이 존재합니다."),

    //날짜 관련
    MONTH_RANGE("월은 1월 부터 12월 사이를 입력해야 합니다."),
    DAY_RANGE("월에 존재할 수 없는 날입니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
