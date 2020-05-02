package mars;

public enum Direction {
    E(0),
    N(1),
    W(2),
    S(3);

    Direction(int degre) {
        this.degre = degre;
    }

    private int degre;

    public int getDegre() {
        return this.degre;
    }
}
