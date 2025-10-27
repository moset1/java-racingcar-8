package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceServiceTest extends NsTest {

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

        List<Player> players = Arrays.asList(pobi, woni, jun);

        // when
        List<Player> winners = raceService.selectWinner(players);

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
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

        List<Player> players = Arrays.asList(pobi, woni, jun);

        // when
        List<Player> winners = raceService.selectWinner(players);

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Player::getName).containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상일 경우 전진")
    void runRace_전진() {
        // given
        Player pobi = new Player("pobi");
        List<Player> players = List.of(pobi);
        int initialDistance = pobi.getMovedDistance();

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    raceService.runRace(players);
                    assertThat(pobi.getMovedDistance()).isEqualTo(initialDistance + 1);
                },
                4
        );
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만일 경우 정지")
    void runRace_정지() {
        // given
        Player pobi = new Player("pobi");
        List<Player> players = List.of(pobi);
        int initialDistance = pobi.getMovedDistance();

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    raceService.runRace(players);
                    assertThat(pobi.getMovedDistance()).isEqualTo(initialDistance);
                },
                3
        );
    }

    @Override
    protected void runMain() {
    }
}
