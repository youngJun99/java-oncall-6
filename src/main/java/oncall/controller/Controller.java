package oncall.controller;

import oncall.dto.WorkSchedule;
import oncall.service.WorkerCalenderService;
import oncall.view.OutputView;

import java.util.List;

public class Controller {

    private final WorkerCalenderService workerCalenderService;
    private final OutputView outputView;

    public Controller(WorkerCalenderService workerCalenderService, OutputView outputView) {
        this.workerCalenderService = workerCalenderService;
        this.outputView = outputView;
    }

    public void run() {
        List<WorkSchedule> workCalender = workerCalenderService.generateWorkCalender();
        outputView.printWorkerCalender(workCalender);
    }
}
