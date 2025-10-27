package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("정상적인 자동차 이름 입력")
    void validateCarNames_정상() {
        // given
        String carNamesInput = "mose,semo";

        // when & then
        assertDoesNotThrow(() -> inputValidator.validateCarNames(carNamesInput));
    }

    @Test
    @DisplayName("자동차 이름이 5를 초과하는 경우 예외 발생")
    void validateCarNames_이름_길이_초과() {
        // given
        String carNamesInput = "moset1,semo";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarNames(carNamesInput);
        });
        assertEquals("자동차 이름은 5자 이하 제한입니다. : moset1", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 중복된 경우 예외 발생")
    void validateCarNames_이름_중복() {
        // given
        String carNamesInput = "mose,mose,semo";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarNames(carNamesInput);
        });
        assertEquals("자동차 이름이 중복되었습니다. : mose", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 입력이 null인 경우 예외 발생")
    void validateCarNames_null_입력() {
        // given
        String carNamesInput = null;

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarNames(carNamesInput);
        });
        assertEquals("자동차 이름은 비어있을 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 입력이 쉼표로 끝나는 경우 예외 발생")
    void validateCarNames_쉼표로_끝남() {
        // given
        String carNamesInput = "pobi,woni,";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarNames(carNamesInput);
        });
        assertEquals("자동차 이름은 쉼표로 끝날 수 없습니다", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우 예외 발생")
    void validateCarNames_이름이_공백() {
        // given
        String carNamesInput = "pobi,,jun";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarNames(carNamesInput);
        });
        assertEquals("자동차 이름은 공백일 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 앞뒤에 공백이 있는 경우 예외 발생")
    void validateCarNames_이름_앞뒤_공백() {
        // given
        String carNamesInput = " pobi ,woni,jun";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarNames(carNamesInput);
        });
        assertEquals("자동차 이름은 공백으로 시작하거나 끝날 수 없습니다. :  pobi ", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 입력이 null인 경우 예외 발생")
    void validateTryCount_null_입력() {
        // given
        String tryCountInput = null;

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateTryCount(tryCountInput);
        });
        assertEquals("시도 횟수는 비어있을 수 없습니다.", exception.getMessage());
    }

    @Test
    void validateTryCount_음수_입력() {
        // given
        String tryCountInput = "-1";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateTryCount(tryCountInput);
        });
        assertEquals("시도 횟수는 양의 정수여야 합니다.", exception.getMessage());
    }

    @Test
    void validateTryCount_숫자_미입력() {
        // given
        String tryCountInput = "열번";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateTryCount(tryCountInput);
        });
        assertEquals("시도 횟수는 숫자만 입력 가능합니다.", exception.getMessage());
    }
}