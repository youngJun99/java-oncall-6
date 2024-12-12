package oncall.handler;

import camp.nextstep.edu.missionutils.Console;
import oncall.constants.Errors;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    private static InputHandler inputHandler;

    @AfterEach
    void set() {
        Console.close();
    }

    @BeforeAll
    static void setUp() {
        inputHandler = new InputHandler(new InputView(),new InputValidator());
    }

    @ParameterizedTest
    @DisplayName("직원의 수는 5명부터 35명 사이여야 한다.")
    @ValueSource(strings = {"직원한명,직원두명","직원한명"})
    void invalidWorkersLength(String input) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Workers workers = inputHandler.getWeekDayWorkers();
        }).hasMessageContaining(String.format(Errors.WORKERS_LENGTH.getMessage(),5,35));
    }

    @ParameterizedTest
    @DisplayName("중복된 직원이 존재하면 에러가 난다.")
    @ValueSource(strings = {"김직원,김직원,이직원,박직원,강직원","직원김,직원박,직원민,직원정,직원정,직원정"})
    void invalidWorkerName(String input) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Workers workers = inputHandler.getWeekDayWorkers();
        }).hasMessageContaining(String.format(Errors.DUPLICATE_WORKERS.getMessage()));
    }

}
