package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleView {

    public ConsoleView() {
    }

    public String readCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String readTryCount() {

        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void printRaceStatus(List<Player> players) {

        for (Player player : players) {
            String repeatedString = "-".repeat(player.getMovedDistance());
            System.out.println(player.getName() + " : " + repeatedString);
        }
        System.out.println();
    }

    public void printWinner(List<Player> winners) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + sb);
    }

    public void printRaceResultsHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
