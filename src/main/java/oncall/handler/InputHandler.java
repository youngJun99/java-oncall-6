package oncall.handler;

import oncall.domain.Date;
import oncall.domain.Workers;
import oncall.view.InputView;

import java.util.Arrays;
import java.util.List;

public class InputHandler {

    private static final String DELIMITER = ",";

    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputHandler(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public Date getDateFromUser() {
        String input = inputView.getDateInfo();
        inputValidator.validateDateInput(input);
        List<String> inputSplit = Arrays.asList(input.split(DELIMITER));
        int inputMonth = Integer.parseInt(inputSplit.get(0));
        String inputDayOfWeek = inputSplit.get(1);
        return new Date(inputMonth, inputDayOfWeek);
    }

    public Workers getWeekDayWorkers() {
        String input = inputView.getWeekDayWorkers();
        inputValidator.validateWorkersInput(input);
        return new Workers(Arrays.asList(input.split(DELIMITER)));
    }

    public Workers getWeekEndWorkers() {
        String input = inputView.getWeekEndWorkers();
        inputValidator.validateWorkersInput(input);
        return new Workers(Arrays.asList(input.split(DELIMITER)));
    }

}
