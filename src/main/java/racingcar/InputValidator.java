package racingcar;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public void validateCarNames(String carNamesInput) {

        validateCarNamesInput(carNamesInput);

        String[] names = carNamesInput.split(",");
        validateNameList(names);
    }

    private void validateCarNamesInput(String carNamesInput) {

        if (carNamesInput == null || carNamesInput.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (carNamesInput.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 끝날 수 없습니다");
        }
    }

    private void validateNameList(String[] names) {

        Set<String> uniqueNames = new HashSet<>();

        for (String name : names) {

            validateSingleName(name);

            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다. : " + name);
            }
        }
    }

    private void validateSingleName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (name.startsWith(" ") || name.endsWith(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백으로 시작하거나 끝날 수 없습니다. : " + name);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하 제한입니다. : " + name);
        }
    }


    public void validateTryCount(String tryCountInput) {

        if (tryCountInput == null || tryCountInput.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 비어있을 수 없습니다.");
        }

        int tryCount;
        try {
            tryCount = Integer.parseInt(tryCountInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }

        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
    }
}
