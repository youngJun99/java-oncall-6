package oncall;

import oncall.controller.Controller;
import oncall.handler.InputHandler;
import oncall.handler.InputValidator;
import oncall.service.WorkerCalenderService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    public Controller controller() {
        InputHandler inputHandler = new InputHandler(
                new InputView(),
                new InputValidator());

        return new Controller(
                new WorkerCalenderService(inputHandler),
                new OutputView());
    }

}
