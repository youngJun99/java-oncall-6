package oncall.constants;

import java.util.Arrays;

public enum DayOfWeek {
    월,
    화,
    수,
    목,
    금,
    토,
    일;


    public static DayOfWeek of(String name) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.name().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(Errors.NO_SUCH_DAY_OF_WEEK.getMessage()));
    }

    public static boolean isInDayOfWeek(String name) {
        return Arrays.stream(DayOfWeek.values())
                .anyMatch(dayOfWeek -> dayOfWeek.name().equals(name));
    }

    public static DayOfWeek getNextDayOfWeek(DayOfWeek inputDayOfWeek) {

    }

}

"""
### 요일(DayOfWeek) - Enum
-[ ] 입력받은 한국어 요일 String에 대해서 Enum으로 돌려줄 수 있어야 한다.
        -[ ] 다음 요일을 돌려줄 수 있어야 한다.
        -[ ] String을 받았을 경우 Enum에 존재하는 것인지 반환해야 한다. ->Validator에서 쓰일 것.
"""

