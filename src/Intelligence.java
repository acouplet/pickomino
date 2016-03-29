import java.util.*;

abstract class Intelligence {
    private int nbPlayers;
    private TreeSet<Tile> gameTiles;
    private int myScore;
    private int[] scores;
    private Tile[] myTileStack;
    private Tile[][] tileStacks;
    private String myName;
    private String[] names;

    public void setInitialValues(int nbPlayers, String myName, String[] names) {
        this.nbPlayers 	= nbPlayers;
        this.myName		= myName;
        this.names		= names;
    }

    // fonction appelée à chaque tour par le maitre de jeu qui met à jour les valeurs
    public void setValues(TreeSet<Tile> gameTiles, int myScore, int[] scores, Tile[] myTileStack, Tile[][] tileStacks) {
        this.gameTiles 	= gameTiles;
        this.myScore = myScore;
        this.scores = scores;
        this.myTileStack = myTileStack;
        this.tileStacks = tileStacks;
    }

    public abstract void gameStart();
    public abstract void turnStart();
    public abstract boolean rollOrStop(TreeMap<Die, Integer> dice);
    public abstract Tile chooseTile(TreeMap<Die, Integer> dice);
    public abstract Die chooseDice(TreeMap<Die, Integer> dice, TreeMap<Die, Integer> roll);
    public abstract void turnEnd();
    public abstract void gameEnd();
}

