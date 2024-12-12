package oncall.handler;

import camp.nextstep.edu.missionutils.Console;
import oncall.constants.Errors;
import oncall.domain.Worker;
import oncall.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeAll
    static void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("올바르게 월과 요일을 입력하지 않으면 에러가 난다")
    @ValueSource(strings = {"5월,일","5월의,일","five,일"})
    void invalidDateInfoInput(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateMonthAndDayInput(input);
        }).hasMessageContaining(Errors.INVALID_DATE_INFO_INPUT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("알맞은 형태로 입력해도 존재하지 않는 요일이면 에러가 난다.")
    @ValueSource(strings = {"5,필","4,원","6,홥"})
    void invalidDayOfWeek(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateMonthAndDayInput(input);
        }).hasMessageContaining(Errors.NO_SUCH_DAY_OF_WEEK.getMessage());
    }

    @ParameterizedTest
    @DisplayName("직원의 이름을 잘못된 형태로 입력하면 에러가 난다.")
    @ValueSource(strings = {"김직원,이직원,worker","김지원:이직원:강직원","김직원,"})
    void invalidWorkerNameInput(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateWorkersInput(input);
        }).hasMessageContaining(Errors.INVALID_WORKER_INPUT.getMessage());
    }

}
