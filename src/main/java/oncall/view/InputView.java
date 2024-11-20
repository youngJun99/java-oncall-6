package oncall.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String getInputDate() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return readLine();
    }

    public String getWeekDayWorkSchedule() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return readLine();
    }

    public String getWeekEndWorkSchedule() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return readLine();
    }
}