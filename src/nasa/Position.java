package mars;

public class Position {
    private int x, y;

    public Position() {
        this(0,0);
    }

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
