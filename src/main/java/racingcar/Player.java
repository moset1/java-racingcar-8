package racingcar;

public class Player {

    private String name;
    private Integer movedDistance;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.movedDistance = 0;
    }

    public Integer getMovedDistance() {
        return movedDistance;
    }

    public void setMovedDistance(Integer movedDistance) {
        this.movedDistance = movedDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
