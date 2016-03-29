import java.util.Stack;

class Player {
    private int id;
    private int score;
    private String name;
    private Stack<Tile> tileStack;
    private Intelligence intelligence;

    private static int playerCount = 0;

    public Player(String name, Intelligence intelligence) {
        this.id = playerCount++;
        this.score = 0;
        this.name = name;
        this.tileStack = new Stack<Tile> ();
        this.intelligence = intelligence;
    }

    public Player(Intelligence intelligence) {
        this("Player " + playerCount, intelligence);
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        return id == ((Player)o).getId();
    }

    public Tile[] getTileStack() {
        return (Tile[])(tileStack.toArray());
    }

    public Intelligence getIntelligence() {
        return intelligence;
    }

    public Tile getTopTile() {
        if(tileStack.empty()) 
            return null;
        else
            return tileStack.peek();
    }

    public Tile popTile() {
        if(tileStack.empty())
            return null;
        else {
            Tile t = tileStack.pop();
            score -= t.getNbWorms();
            return t;
        }
    }

    public void pushTile(Tile t) {
        tileStack.push(t);
        score += t.getNbWorms();
    }
}

