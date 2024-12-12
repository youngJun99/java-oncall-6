package oncall.controller;

import oncall.dto.WorkScheduleDto;
import oncall.service.WorkScheduleService;
import oncall.view.OutputView;

import java.util.List;

public class Controller {

    private final WorkScheduleService workScheduleService;
    private final OutputView outputView;


    public Controller(WorkScheduleService workScheduleService, OutputView outputView) {
        this.workScheduleService = workScheduleService;
        this.outputView = outputView;
    }

    public void run() {
        List<WorkScheduleDto> workScheduleDtos = workScheduleService.getWorkSchedule();
        outputView.printSchedule(workScheduleDtos);
    }
}
