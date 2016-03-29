class Game {
    private int nbPlayers;
    private Player[] players;
    private Set<Tile> gameTiles;

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

    public startGame(int firstPlayerId) {
        // on initialise les intelligences et on appelle leur fonction de début de partie
        for(Player p : players) {
            String[] enemyNames = new String[nbPlayers-1];
            int cnt = 0;
            for(Player pp : players)
                if(!pp.equals(p))
                    enemyNames[cnt++] = pp.getName();
            p.intelligence.setInitialValues(nbPlayers, p.getName(), enemyNames);
            p.intelligence.gameStart();
        }

        // compteur de tours
        while(gameTiles.size())
            for(int turn = 0; turn < nbPlayers && gameTiles.size(); ++turn)
                playTurn(players[(firstPlayerId + turn) % nbPlayers]);
    }

    public void playTurn(Player currentPlayer) {
        currentPlayer.intelligence.setValues(
        currentPlayer.intelligence.turnStart();

        
