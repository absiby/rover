package nasa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover(new Position(1,2), Direction.N);
    }

    @Test
    void switchLeft() {
        rover.switchLeft();
        assertSame(Direction.W, rover.getDirection());
    }

    @Test
    void switchRight() {
        rover.switchRight();
        assertSame(Direction.E, rover.getDirection());
    }

    @Test
    void getForwardLocation() {
        Position position = rover.getForwardLocation();
        assertAll(
                () -> assertEquals(1, position.getX()),
                () -> assertEquals(3, position.getY())
        );

    }

    @Test
    void moveTo() {
        rover.moveTo(new Position(2,2));
        Position position = rover.getPosition();
        assertAll(
                () -> assertEquals(2, position.getX()),
                () -> assertEquals(2, position.getY())
        );
    }
}