package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final ConsoleView consoleView;
    private final InputValidator inputValidator;
    private final RaceService raceService;

    public GameController() {
        this.consoleView = new ConsoleView();
        this.inputValidator = new InputValidator();
        this.raceService = new RaceService();
    }

    public void runRacingGame() {

        List<String> carNamesList = getValidCarNames();

        int tryCount = getValidTryCount();

        List<Player> players = makePlayers(carNamesList);

        consoleView.printRaceResultsHeader();
        for (int i = 0; i < tryCount; i++) {
            raceService.runRace(players);
            consoleView.printRaceStatus(players);
        }

        List<Player> winners = raceService.selectWinner(players);

        consoleView.printWinner(winners);
    }

    private List<Player> makePlayers(List<String> carNamesList) {

        List<Player> players = new ArrayList<>();
        for (String name : carNamesList) {
            players.add(new Player(name));
        }
        return players;
    }

    private List<String> getValidCarNames() {

        String carNamesInput = consoleView.readCarNames();
        inputValidator.validateCarNames(carNamesInput);
        return List.of(carNamesInput.split(","));

    }

    private Integer getValidTryCount() {

        String tryCountInput = consoleView.readTryCount();
        inputValidator.validateTryCount(tryCountInput);
        return Integer.valueOf(tryCountInput);

    }

}
