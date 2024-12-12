package oncall.domain;

import oncall.constants.Errors;
import oncall.service.WorkScheduleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @ParameterizedTest
    @DisplayName("이름이 5글자를 넘어가면 에러가 생긴다")
    @ValueSource(strings = {"정말정말정말긴이름","이름이다섯글자이상"})
    void invalidWorkerName(String input) {
        assertThatThrownBy(() -> {
            Worker worker = new Worker(input);
        }).hasMessageContaining(String.format(Errors.WORKER_NAME_LENGTH.getMessage(),5));
    }

}
