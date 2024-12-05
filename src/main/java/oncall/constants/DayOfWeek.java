package oncall.constants;

public enum DayOfWeek {
    월요일(true, "월"),
    화요일(true, "화"),
    수요일(true, "수"),
    목요일(true, "목"),
    금요일(true, "금"),
    토요일(false, "토"),
    일요일(false, "일");

    private final boolean work;
    private final String name;

    DayOfWeek(boolean work, String name) {
        this.work = work;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isWorkDay() {
        return work;
    }

    public static DayOfWeek getNextDayOfWeek(DayOfWeek dayOfWeek) {
        if (dayOfWeek.name.equals("일")) {
            return DayOfWeek.월요일;
        }
        return DayOfWeek.values()[dayOfWeek.ordinal() + 1];
    }
}
