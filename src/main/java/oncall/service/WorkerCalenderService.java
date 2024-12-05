package oncall.service;

import oncall.domain.Date;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.dto.WorkSchedule;
import oncall.handler.InputHandler;
import oncall.utils.ErrorCatcher;

import java.util.ArrayList;
import java.util.List;

import static oncall.constants.Holiday.isHoliday;

public class WorkerCalenderService {

    private final InputHandler inputHandler;
    private Date date;
    private Workers weekdayWorkers;
    private Workers weekEndWorkers;


    public WorkerCalenderService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<WorkSchedule> generateWorkCalender() {
        this.date = ErrorCatcher.returnRetryHandler(inputHandler::getDateFromUser);
        ErrorCatcher.voidRetryHandler(this::initializeWorkers);

        List<WorkSchedule> workCalender = new ArrayList<>();
        Worker workedWorker = getFirstWorker();
        workCalender.add(generateWorkSchedule(workedWorker));

        while (date.hasNextDay()) {
            workedWorker = getNextWorker(workedWorker);
            workCalender.add(generateWorkSchedule(workedWorker));
        }

        return workCalender;
    }

    private Worker getFirstWorker() {
        if (!date.isWorkDay() || isHoliday(date)) {
            return weekEndWorkers.getFirstWorker();
        }
        return weekdayWorkers.getFirstWorker();
    }

    private Worker getNextWorker(Worker previousWorker) {
        if (!date.isWorkDay() || isHoliday(date)) {
            return weekEndWorkers.getNextWorker(previousWorker);
        }
        return weekdayWorkers.getNextWorker(previousWorker);
    }

    private WorkSchedule generateWorkSchedule(Worker worker) {
        WorkSchedule workSchedule = new WorkSchedule(
                date.getMonth(),
                date.getDay(),
                date.getDayOfWeek(),
                worker.getName(),
                isHoliday(date) && date.isWorkDay());
        date.nextDay();
        return workSchedule;
    }


    private void initializeWorkers() {
        this.weekdayWorkers = inputHandler.getWeekDayWorkers();
        this.weekEndWorkers = inputHandler.getWeekEndWorkers();
    }

}
