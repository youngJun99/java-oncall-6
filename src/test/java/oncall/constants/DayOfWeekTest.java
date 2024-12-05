package oncall.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekTest {

    @Test
    void test() {
        String input = "화";
        DayOfWeek.of(input);
    }
}
