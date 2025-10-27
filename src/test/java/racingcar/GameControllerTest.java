package racingcar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameControllerTest {

    private static final InputStream originalIn = System.in;
    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = new GameController();
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("정상 실행 테스트")
    void runRacingGameTest() {

        // given
        String simulatedInput = "pobi,woni,jun\n5\n";

        InputStream fakeIn = new ByteArrayInputStream(simulatedInput.getBytes());

        System.setIn(fakeIn);

        // When
        GameController controller = new GameController();
        controller.runRacingGame();

    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }
}