package oncall.domain;

import oncall.domain.vo.MyMonth;
import oncall.dto.WorkDateDto;

import java.util.List;
import java.util.stream.IntStream;

import static oncall.domain.Holiday.isHoliday;
import static oncall.domain.KoreanWeekDay.getNameOf;
import static oncall.domain.KoreanWeekDay.isWeekEnd;

public class MyDate {

    private final MyMonth month;
    private int weekDayIndex;
    private final int endDayOfMonth;

    public MyDate(MyMonth month, int weekDayIndex) {
        this.month = month;
        this.weekDayIndex = weekDayIndex;
        this.endDayOfMonth = findEndDayOfMonth(month.getMonth());
    }

    private int findEndDayOfMonth(int month) {
        if (month == 2) {
            return 28;
        }
        if (List.of(1, 3, 5, 7, 8, 10, 12).contains(month)) {
            return 31;
        }
        return 30;
    }

    public List<WorkDateDto> getWorkDateCalender() {
        return IntStream.rangeClosed(1, endDayOfMonth)
                .mapToObj(day -> {
                    WorkDateDto dto = new WorkDateDto(month.getMonth(), day, getNameOf(day), checkRestDay(weekDayIndex, day),isHoliday(month.getMonth(),day));
                    weekDayIndex++;
                    return dto;
                }).toList();
    }

    private boolean checkRestDay(int weekDayIndex, int day) {
        return isWeekEnd(weekDayIndex) || isHoliday(month.getMonth(), day);
    }

}

