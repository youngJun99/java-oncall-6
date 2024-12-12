package oncall;

import oncall.domain.Date;
import oncall.domain.Workers;
import oncall.handler.InputHandler;
import oncall.handler.InputValidator;
import oncall.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new InputView(), new InputValidator());
        Date date = inputHandler.getDateInformation();
    }
}
