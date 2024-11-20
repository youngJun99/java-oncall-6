package oncall;

import oncall.controller.OnCallController;
import oncall.handler.InputHandler;
import oncall.handler.InputValidatorImpl;
import oncall.service.DateCalenderService;
import oncall.service.WorkScheduleMatchingService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    public OnCallController onCallController() {
        InputHandler inputHandler = new InputHandler(new InputView(), new InputValidatorImpl());
        return new OnCallController(new DateCalenderService(inputHandler),
                new WorkScheduleMatchingService(inputHandler),
                new OutputView());
    }
}
