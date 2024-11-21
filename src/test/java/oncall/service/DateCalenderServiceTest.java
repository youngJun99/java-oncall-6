package oncall.service;

import camp.nextstep.edu.missionutils.Console;
import oncall.dto.WorkDateDto;
import oncall.handler.InputHandler;
import oncall.handler.InputValidatorImpl;
import oncall.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateCalenderServiceTest {

    private DateCalenderService dateCalenderService = new DateCalenderService(new InputHandler(new InputView(),new InputValidatorImpl()));

    @AfterEach
    void set() {
        Console.close();
    }

    @Test
    void test() {
        //given
        String readLine = "2,일";
        System.setIn(new ByteArrayInputStream(readLine.getBytes()));

        List<WorkDateDto> workDateDtos =  dateCalenderService.getWorkDateCalender();
        for (WorkDateDto workDateDto : workDateDtos) {
            System.out.println(workDateDto);
        }
    }

}
