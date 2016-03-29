import java.util.*;

abstract class Intelligence {
    protected int nbPlayers;
    protected TreeSet<Tile> gameTiles;
    protected int myScore;
    protected int[] scores;
    protected Tile[] myTileStack;
    protected Tile[][] tileStacks;
    protected String myName;
    protected String[] names;

    public void setInitialValues(int nbPlayers, String myName, String[] names) {
        this.nbPlayers 	= nbPlayers;
        this.myName		= myName;
        this.names		= names;
    }

    // fonction appelée à chaque tour par le maitre de jeu qui met à jour les valeurs
    public void setValues(TreeSet<Tile> gameTiles, int myScore, int[] scores, Tile[] myTileStack, Tile[][] tileStacks) {
        this.gameTiles      = gameTiles;
        this.myScore        = myScore;
        this.scores         = scores;
        this.myTileStack    = myTileStack;
        this.tileStacks     = tileStacks;
    }

    public abstract void gameStart();
    public abstract void turnStart();
    public abstract boolean rollOrStop(DiceSet dice);
    public abstract Tile chooseTile(DiceSet dice);
    public abstract Die chooseDice(DiceSet dice, DiceSet roll);
    public abstract void turnEnd();
    public abstract void gameEnd();
}

