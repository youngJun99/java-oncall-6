package oncall.service;

import oncall.domain.MyDate;
import oncall.domain.vo.MyMonth;
import oncall.dto.StartDateDto;
import oncall.dto.WorkDateDto;
import oncall.handler.InputHandler;

import java.util.List;

import static oncall.domain.KoreanWeekDay.getIndexOf;
import static oncall.utils.ErrorCatcher.retryHandler;

public class DateCalenderService {

    private final InputHandler inputHandler;
    private MyDate myDate;

    public DateCalenderService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<WorkDateDto> getWorkDateCalender() {
        retryHandler(this::InitializeMyDate);
        return myDate.getWorkDateCalender();
    }

    private void InitializeMyDate() {
        StartDateDto startDate = inputHandler.getDateInfo();
        MyMonth startMonth = new MyMonth(startDate.month());
        int startWeekDayIndex = getIndexOf(startDate.koreanWeekDay());
        myDate =  new MyDate(startMonth,startWeekDayIndex);
    }
}
