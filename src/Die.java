class Die implements Comparable<Die> {
    public static final int NB_FACES = 6;

    private int face;

    private int randomFace() {
        return (int)(Math.random() * NB_FACES + 1);
    }

    public Die() {
        face = randomFace();
    }

    public int getFace() {
        return face;
    }

    public void roll() {
        face = randomFace();
    }

    public int compareTo(Die other) {
        return Integer.compare(this.face, other.face);
    }
}

