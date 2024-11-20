package oncall.controller;

import oncall.dto.MatchedWorkDto;
import oncall.dto.WorkDateDto;
import oncall.service.DateCalenderService;
import oncall.service.WorkScheduleMatchingService;
import oncall.view.OutputView;

import java.util.List;

public class OnCallController {
    private final DateCalenderService dateCalenderService;
    private final WorkScheduleMatchingService workScheduleMatchingService;
    private final OutputView outputView;

    public OnCallController(DateCalenderService dateCalenderService, WorkScheduleMatchingService workScheduleMatchingService, OutputView outputView) {
        this.dateCalenderService = dateCalenderService;
        this.workScheduleMatchingService = workScheduleMatchingService;
        this.outputView = outputView;
    }

    public void run() {
        List<WorkDateDto> workDateCalender =dateCalenderService.getWorkDateCalender();
        List<MatchedWorkDto> matchedWorkSchedule = workScheduleMatchingService.getMatchedWorkSchedule(workDateCalender);
        outputView.printResult(matchedWorkSchedule);
    }
}
