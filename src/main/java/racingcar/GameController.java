package racingcar;

import java.util.List;

public class GameController {

    private final ConsoleView consoleView;
    private final InputValidator inputValidator;

    public GameController() {
        this.consoleView = new ConsoleView();
        this.inputValidator = new InputValidator();

    }

    public void run() {

        List<String> carNamesList = getValidCarNames();
        Integer tryCount = getValidateTryCount();



    }

    private List<String> getValidCarNames() {

        String carNamesInput = consoleView.readCarNames();
        inputValidator.validateCarNames(carNamesInput);
        return List.of(carNamesInput.split(","));

    }

    private Integer getValidateTryCount() {

        String tryCountInput = consoleView.readTryCount();
        inputValidator.validateTryCount(tryCountInput);
        return Integer.valueOf(tryCountInput);

    }

}
