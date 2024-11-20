package oncall;

import oncall.controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OnCallController onCallController = appConfig.onCallController();
        onCallController.run();
    }
}
