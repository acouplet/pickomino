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

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Tile getTopTile() {
        return tileStack.peek();
    }

    public void pushTile(Tile t) {
        tileStack.push(t);
    }

    public Tile popTile() {
        return tileStack.pop();
    }
}

