package oncall.service;

import oncall.domain.WorkSchedule;
import oncall.domain.vo.Worker;
import oncall.dto.MatchedWorkDto;
import oncall.dto.WorkDateDto;
import oncall.handler.InputHandler;

import java.util.List;

import static oncall.utils.ErrorCatcher.retryHandler;
import static org.mockito.ArgumentMatchers.isNull;

public class WorkScheduleMatchingService {

    private final InputHandler inputHandler;
    private WorkSchedule workDaySchedule;
    private WorkSchedule restDaySchedule;
    private Worker currentWorker;

    public WorkScheduleMatchingService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<MatchedWorkDto> getMatchedWorkSchedule(List<WorkDateDto> workSchedule) {
        retryHandler(this::InitializeSchedules);
        return workSchedule.stream()
                .map(workDateDto -> {
                    return new MatchedWorkDto(workDateDto.month(),
                            workDateDto.monthDay(),
                            workDateDto.koreanWeekDay(),
                            workDateDto.restDay(),
                            getWorker(workDateDto.restDay()));
                }).toList();
    }

    private void InitializeSchedules() {
        workDaySchedule = new WorkSchedule(inputHandler.getWorkDayWorkSchedule().stream()
                .map(Worker::new)
                .toList());
        restDaySchedule = new WorkSchedule(inputHandler.getRestDayWorkSchedule().stream()
                .map(Worker::new)
                .toList());
    }

    private String getWorker(boolean restDay) {
        if (restDay) {
            return ProcessRestDay();
        }
        return ProcessWorkDay();
    }

    private String ProcessWorkDay() {
        if (currentWorker == null) {
            currentWorker = workDaySchedule.getFirstWorker();
            return currentWorker.getName();
        }
        currentWorker = workDaySchedule.getNextWorker(currentWorker);
        return currentWorker.getName();
    }

    private String ProcessRestDay() {
        if (currentWorker == null) {
            currentWorker = restDaySchedule.getFirstWorker();
            return currentWorker.getName();
        }
        currentWorker = restDaySchedule.getNextWorker(currentWorker);
        return currentWorker.getName();
    }
}
