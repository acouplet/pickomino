class Die implements Comparable<Die> {
    public static final int NB_FACES = 6;
    public static final int WORM = NB_FACES;

    private int face;

    private int randomFace() {
        return (int)(Math.random() * NB_FACES + 1);
    }

    public Die() {
        face = randomFace();
    }
    
    public Die(int face) {
    	this.face = face;
    }

    public int getFace() {
        return face;
    }
    
    public int getValue() {
    	return min(face,WORM-1);
    }

    public void roll() {
        face = randomFace();
    }

    public int compareTo(Die other) {
        return Integer.compare(this.face, other.face);
    }
}

