package oncall.constants;

public enum Errors {

    DATE_NOT_VALID("존재할 수 없는 날짜입니다.");


    private static final String PREFIX = "[ERROR] ";

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMeesage() {
        return PREFIX+message;
    }
}
