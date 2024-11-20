package oncall.domain;

import oncall.constants.Errors;
import oncall.domain.vo.MyMonth;
import oncall.domain.vo.MyMonthDay;
import oncall.dto.MyDateDto;

import java.time.MonthDay;
import java.util.List;
import java.util.stream.IntStream;

import static oncall.utils.ErrorCatcher.tryMethodAndThrow;

public class MyDate {

    private final MyMonth month;
    private final MyMonthDay monthDay;
    private final MyMonthDay endDayOfMonth;

    public MyDate(MyMonth month, MyMonthDay monthDay) {
        validateDate(month.getMonth(), monthDay.getMonthDay());
        endDayOfMonth = findEndDayOfMonth(month.getMonth());
        this.month = month;
        this.monthDay = monthDay;
    }

    private void validateDate(int month, int monthDay) {

        if (month == 2 || monthDay > 28) {
            throw new IllegalArgumentException(Errors.DATE_NOT_VALID.getMessage());
        }
        tryMethodAndThrow(() -> MonthDay.of(month, monthDay), Errors.DATE_NOT_VALID.getMessage());
    }

    private MyMonthDay findEndDayOfMonth(int month) {
        if (month == 2) {
            return new MyMonthDay(28);
        }
        if (List.of(1, 3, 5, 7, 8, 10, 12).contains(month)) {
            return new MyMonthDay(31);
        }
        return new MyMonthDay(30);
    }

    public List<MyDateDto> getWorkDates() {
        return IntStream.rangeClosed(monthDay.getMonthDay(), endDayOfMonth.getMonthDay())
                .mapToObj(day -> new MyDateDto(month.getMonth(), day))
                .toList();
    }
}

