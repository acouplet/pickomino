import java.util.Map;

class EmptyAI extends Intelligence {
    public void gameStart() {
    
    }

    public void turnStart() {

    }

    public boolean rollOrStop(Map<Die, Integer> dice) {
        return false;
    }

    public Tile chooseTile(Map<Die, Integer> dice) {
        return null;
    }

    public Die chooseDice(Map<Die, Integer> dice, Map<Die, Integer> roll) {
        return null;
    }

    public void turnEnd() {

    }

    public void gameEnd() {

    }
}
