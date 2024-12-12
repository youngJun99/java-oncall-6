package oncall;

import oncall.controller.Controller;
import oncall.handler.InputHandler;
import oncall.handler.InputValidator;
import oncall.service.WorkScheduleService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    public Controller controller() {
        return new Controller(
                new WorkScheduleService(
                        new InputHandler(
                                new InputView(),
                                new InputValidator())),
                new OutputView());
    }
}
