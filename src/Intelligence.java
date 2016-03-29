import java.util.*;

abstract class Intelligence {
    private int nbPlayers;
    private Set<Tile> gameTiles;
    private int myScore;
    private int[] scores;
    private Tile[] myTileStack;
    private Tile[][] tileStacks;

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }

    // fonction appelée à chaque tour par le maitre de jeu qui met à jour les valeurs
    public void setValues(Set<Tile> gameTiles, int myScore, int[] scores, Tile[] myTileStack, Tile[][] tileStacks) {
        this.gameTiles = gameTiles;
        this.myScore = myScore;
        this.scores = scores;
        this.myTileStack = myTileStack;
        this.tileStacks = tileStacks;
    }

    public abstract void gameStart();
    public abstract void turnStart();
    public abstract boolean rollOrStop(Map<Die, Integer> dice);
    public abstract Tile chooseTile(Map<Die, Integer> dice);
    public abstract Die chooseDice(Map<Die, Integer> dice, Map<Die, Integer> roll);
    public abstract void turnEnd();
    public abstract void gameEnd();
}

