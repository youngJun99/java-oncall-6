package oncall.domain;

import java.time.DayOfWeek;

public enum KoreanWeekDay {
    월요일(DayOfWeek.of(1),"월"),
    화요일(DayOfWeek.of(2),"화"),
    수요일(DayOfWeek.of(3),"수"),
    목요일(DayOfWeek.of(4),"목"),
    금요일(DayOfWeek.of(5),"금"),
    토요일(DayOfWeek.of(6),"토"),
    일요일(DayOfWeek.of(7),"일");

    private DayOfWeek dayOfWeek;
    private String name;

    KoreanWeekDay(DayOfWeek dayOfWeek,String name) {
        this.dayOfWeek = dayOfWeek;
        this.name = name;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getName() {
        return name;
    }
}
