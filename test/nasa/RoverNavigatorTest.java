package nasa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static nasa.RoverNavigator.isValidLocation;
import static org.junit.jupiter.api.Assertions.*;

class RoverNavigatorTest {

    private Rover rover;
    private int[] plateauSize;

    @BeforeEach
    void setUp() {
        rover = new Rover(new Position(1, 2), Direction.N);
        plateauSize = new int[]{5, 5};
    }

    @Test
    void navigateThroughGoodPath() throws InvalidPathException {
        String goodPath = "LMLMLMLMM";
        assertEquals("1 3 N", RoverNavigator.navigate(rover, goodPath, plateauSize));
    }

    @Test
    void navigateThroughWrongPath() {
        String wrongPath = "LMLMLMLMMRMMMMMM";
        assertThrows(InvalidPathException.class, () -> RoverNavigator.navigate(rover, wrongPath, plateauSize));
    }

    @Test
    void navigateThroughInvalidPath() {
        String invalidPath = "LMLMLMLBBM";
        assertThrows(InputMismatchException.class, () -> RoverNavigator.navigate(rover, invalidPath, plateauSize));
    }

    @Test
    void validLocation() {
        Position position1 = new Position(1, 2);
        assertTrue(isValidLocation(position1, plateauSize));
    }

    @Test
    void inValidLocation() {
        Position position2 = new Position(-1, 2);
        Position position3 = new Position(1, 8);
        assertFalse(isValidLocation(position2, plateauSize));
        assertFalse(isValidLocation(position3, plateauSize));
    }
}