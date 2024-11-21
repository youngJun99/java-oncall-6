package oncall.handler;

import camp.nextstep.edu.missionutils.Console;
import oncall.dto.StartDateDto;
import oncall.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    private InputHandler inputHandler = new InputHandler(new InputView(), new InputValidatorImpl());

    @AfterEach
    void set() {
        Console.close();
    }

    @Test
    void test() {

        //given
        String readLine = "5,월";
        System.setIn(new ByteArrayInputStream(readLine.getBytes()));

        //when
        StartDateDto startDateDto = inputHandler.getDateInfo();

        System.out.println(startDateDto);
    }

}
