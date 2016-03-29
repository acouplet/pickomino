import java.util.Map;

class EmptyAI extends Intelligence {
    public void gameStart() {
    
    }

    public void turnStart() {

    }

    public boolean rollOrStop(DiceSet dice) {
        return false;
    }

    public Tile chooseTile(DiceSet dice) {
        return null;
    }

    public Die chooseDice(DiceSet dice, DiceSet roll) {
        return null;
    }

    public void turnEnd() {

    }

    public void gameEnd() {

    }
}
