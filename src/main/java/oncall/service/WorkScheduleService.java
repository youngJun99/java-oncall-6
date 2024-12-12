package oncall.service;

import oncall.domain.Date;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.dto.WorkScheduleDto;
import oncall.handler.InputHandler;
import oncall.utils.ErrorCatcher;

import java.util.ArrayList;
import java.util.List;

public class WorkScheduleService {

    private final InputHandler inputHandler;
    private Date date;
    private Workers weekDayWorker;
    private Workers weekEndWorker;
    private Worker previousWorker;


    public WorkScheduleService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<WorkScheduleDto> getWorkSchedule() {
        date = ErrorCatcher.returnRetryHandler(inputHandler::getDateInformation);
        ErrorCatcher.voidRetryHandler(this::initializeWorkers);

        List<WorkScheduleDto> workSchedule = new ArrayList<>();
        workSchedule.add(initializeSchedule());
        date.toNextDay();
        while (date.needNextEmergencyWorker()) {
            workSchedule.add(getSchedule());
            date.toNextDay();
        }
        return workSchedule;
    }

    private WorkScheduleDto getSchedule() {
        if (date.isRestDay() && date.isNotWeekEndRestDay()) {
            previousWorker = weekEndWorker.getNextWorker(previousWorker);
            return getNotWeekEndRestDaySchedule();
        }
        if (date.isRestDay()) {
            previousWorker = weekEndWorker.getNextWorker(previousWorker);
            return getNormalDayWorkSchedule();
        }
        previousWorker = weekDayWorker.getNextWorker(previousWorker);
        return getNormalDayWorkSchedule();
    }

    private WorkScheduleDto initializeSchedule() {
        if (date.isRestDay() && date.isNotWeekEndRestDay()) {
            previousWorker = weekEndWorker.getFirstWorker();
            return getNotWeekEndRestDaySchedule();
        }
        if (date.isRestDay()) {
            previousWorker = weekEndWorker.getFirstWorker();
            return getNormalDayWorkSchedule();
        }
        previousWorker = weekDayWorker.getFirstWorker();
        return getNormalDayWorkSchedule();
    }

    private WorkScheduleDto getNotWeekEndRestDaySchedule() {
        return new WorkScheduleDto(
                date.getMonth(),
                date.getDay(),
                date.getDayOfWeek(),
                true,
                previousWorker);
    }

    private WorkScheduleDto getNormalDayWorkSchedule() {
        return new WorkScheduleDto(
                date.getMonth(),
                date.getDay(),
                date.getDayOfWeek(),
                false,
                previousWorker);
    }


    private void initializeWorkers() {
        weekDayWorker = inputHandler.getWeekDayWorkers();
        weekEndWorker = inputHandler.getWeekEndWorkers();
    }

}
