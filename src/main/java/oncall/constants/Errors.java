package oncall.constants;

public enum Errors {

    //재시도 횟수 관련 에러
    OVER_MAX_RETRIES("최대 재시도 횟수 %d번을 초과했습니다."),

    //직원 관련 에러
    WORKER_NAME_LENGTH("직원의 이름은 %d글자를 넘어가면 안됩니다."),
    DUPLICATE_WORKERS("한 근무표에 중복된 직원이 존재합니다."),
    WORKERS_LENGTH("직원은 최소 %d명 최대 %d명 사이를 입력해야 합니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
