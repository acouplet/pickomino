class Tile implements Comparable<Tile> {
    private int id;
    private int nbWorms;

    public Tile(int id) {
        this.id = id;
        this.nbWorms = 
            (id >= 33) ? 4 : 
            (id >= 29) ? 3 :
            (id >= 25) ? 2 : 1;
    }

    public int getId() {
        return id;
    }

    public int getNbWorms() {
        return nbWorms;
    }

    public int compareTo(Tile other) {
        return Integer.compare(this.id, other.id);
    }
    
    public String toString(){
    	return String.format("[%d;%d]", id, nbWorms);
    }
}

