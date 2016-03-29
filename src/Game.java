import java.util.TreeSet;

class Game {
    public static final int NB_DICE = 8;

    private int nbPlayers;
    private Player[] players;
    private TreeSet<Tile> gameTiles;

    private void initializeGameTiles() {
        for(int i = 21; i <= 36; ++i)
            gameTiles.add(new Tile(i));
    }

    public Game(Intelligence[] intelligences) {
        nbPlayers = intelligences.length;
        for(int i = 0; i < nbPlayers; ++i)
            players[i] = new Player(intelligences[i]);
        initializeGameTiles();
    }

    public Game(String[] names, Intelligence[] intelligences) {
        nbPlayers = names.length;
        for(int i = 0; i < nbPlayers; ++i)
            players[i] = new Player(names[i], intelligences[i]);
        initializeGameTiles();
    }

    public void startGame(int firstPlayerId) {
        // on initialise les intelligences et on appelle leur fonction de début de partie
        for(Player p : players) {
            String[] enemyNames = new String[nbPlayers-1];
            int cnt = 0;
            for(Player pp : players)
                if(!pp.equals(p))
                    enemyNames[cnt++] = pp.getName();
            p.getIntelligence().setInitialValues(nbPlayers, p.getName(), enemyNames);
            p.getIntelligence().gameStart();
        }

        // compteur de tours
        while(gameTiles.size() > 0)
            for(int turn = 0; turn < nbPlayers && gameTiles.size() > 0; ++turn)
                playTurn(players[(firstPlayerId + turn) % nbPlayers]);

        for(Player p : players)
            p.getIntelligence().gameEnd();
    }

    private void playTurn(Player currentPlayer) {
        int myScore = currentPlayer.getScore();
        int[] scores = new int[nbPlayers-1];
        Tile[] myTileStack = currentPlayer.getTileStack();
        Tile[][] tileStacks = new Tile[nbPlayers-1][];
        int cnt = 0;
        for(Player p : players)
            if(!p.equals(currentPlayer)) {
                scores[cnt] = p.getScore();
                tileStacks[cnt] = p.getTileStack();
                ++cnt;
            }

        currentPlayer.getIntelligence().setValues(new TreeSet<Tile>(gameTiles), myScore, scores, myTileStack, tileStacks);

        currentPlayer.getIntelligence().turnStart();

        DiceSet dice = new DiceSet();
        boolean failed = false;
        while(dice.size() < NB_DICE && currentPlayer.getIntelligence().rollOrStop(new DiceSet(dice))) {
            DiceSet roll = new DiceSet(NB_DICE - dice.size());
            // on teste si le joueur peut encore faire des choix
            if(!roll.diff(roll)) {
                failed = true;
                break;
            }
            Die choice = currentPlayer.getIntelligence().chooseDice(new DiceSet(dice), new DiceSet(roll));
            dice.addMultiple(choice, roll.getFrequency(choice));
        }

        if(failed || !canChooseTile(currentPlayer, dice.getValue()))
            failure(currentPlayer);
        else {
            Tile chosenTile = currentPlayer.getIntelligence().chooseTile(new DiceSet(dice));
            transferTile(currentPlayer, chosenTile);
        } 

        currentPlayer.getIntelligence().turnEnd();
    }

    private void failure(Player p) {
        Tile t = p.popTile();
        if(t != null) {
            gameTiles.add(t);
            gameTiles.remove(gameTiles.last());
        }
    }

    private boolean canChooseTile(Player p, int points) {
        Tile t = new Tile(points);
        if(gameTiles.floor(t) != null)
            return true;
        for(Player pp : players)
            if(!pp.equals(p) && pp.getTopTile().equals(t))
                return true;
        return false;
    }

    private void transferTile(Player p, Tile t) {
        p.pushTile(t);
        if(gameTiles.contains(t))
            gameTiles.remove(t);
        else
            for(Player pp : players)
                if(pp.getTopTile().equals(t))
                    pp.popTile();
    }
}

