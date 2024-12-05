package oncall.constants;

public enum Errors {

    //도메인 관련 에러
    WORKER_NAME_RANGE("사원의 이름은 %d 글자 이하여야 합니다."),
    WORKERS_RANGE("사원은 최소 %d명 이상 최대 %d명 이하여야 합니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
