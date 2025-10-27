package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceService {

    public void runRace(List<Player> players) {

        for (Player player : players) {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);

            if (pickedNumber >= 4) {
                player.setMovedDistance(player.getMovedDistance() + 1);
            }
        }

    }

    public List<Player> selectWinner(List<Player> players) {

        List<Player> winners = new ArrayList<>();

        players.sort((o1, o2) -> (o2.getMovedDistance() - o1.getMovedDistance()));
        int max = players.get(0).getMovedDistance();

        for (Player player : players) {
            if (player.getMovedDistance() < max) {
                break;
            }
            winners.add(player);
        }

        return winners;
    }
}
