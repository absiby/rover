package mars;

public class Rover {
    private Position position;
    Direction direction;

    public String location() {
        return this.position.getX() + " " + this.position.getY() + " " + direction;
    }


    public void switchLeft() {
        this.direction = Direction.values()[(direction.getDegre()+1)%4];
    }

    public void switchRight() {
        this.direction = Direction.values()[(direction.getDegre()+3)%4];
    }

    public Position getForwardLocation() {
        Position nextPosition = new Position(this.position);
        switch (direction) {
            case E:
                nextPosition.setX(position.getX()+1);
                break;
            case N:
                nextPosition.setY(position.getY()+1);
                break;
            case W:
                nextPosition.setX(position.getX()-1);
                break;
            case S:
                nextPosition.setY(position.getY()-1);
                break;
        }

        return nextPosition;
    }

    public void moveTo(Position nextPosition) {
        this.position.setX(nextPosition.getX());
        this.position.setY(nextPosition.getY());
    }


    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
