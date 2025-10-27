package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
    }


    @Test
    @DisplayName("우승자가 한 명일 경우")
    void selectWinner_단독_우승() {
        // given
        Player pobi = new Player("pobi");
        pobi.setMovedDistance(5);
        Player woni = new Player("woni");
        woni.setMovedDistance(3);
        Player jun = new Player("jun");
        jun.setMovedDistance(1);

        List<Player> players = new ArrayList<>();

        players.add(pobi);
        players.add(woni);
        players.add(jun);

        // when
        List<Player> winners = raceService.selectWinner(players);

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly(pobi);
    }

    @Test
    @DisplayName("공동 우승자가 여러 명일 경우")
    void selectWinner_공동_우승() {
        // given
        Player pobi = new Player("pobi");
        pobi.setMovedDistance(5);
        Player woni = new Player("woni");
        woni.setMovedDistance(5);
        Player jun = new Player("jun");
        jun.setMovedDistance(1);

        List<Player> players = new ArrayList<>();

        players.add(pobi);
        players.add(woni);
        players.add(jun);


        // when
        List<Player> winners = raceService.selectWinner(players);

        // then
        assertEquals(2, winners.size());
        assertThat(winners).containsExactly(pobi, woni);
    }

}