package nasa;

import java.util.InputMismatchException;

public class RoverNavigator {

    public static String navigate(Rover rover, String path, int[] plateauUpperCorner) throws InvalidPathException {
        if ((rover == null) || plateauUpperCorner == null || plateauUpperCorner.length != 2) {
            return null;
        }

        if (path == null || path.length() == 0) {
            throw new InputMismatchException("chemin invalide");
        }

        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'L':
                    rover.switchLeft();
                    break;
                case 'R':
                    rover.switchRight();
                    break;
                case 'M':
                    Position position = rover.getForwardLocation();
                    if (isValidLocation(position, plateauUpperCorner)) {
                        rover.moveTo(position);
                    } else {
                        throw new InvalidPathException("rover hors plateau");
                    }
                    break;
                default:
                    throw new InputMismatchException("chemin invalide");
            }
        }

        return rover.location();
    }

    public static boolean isValidLocation(Position position, int[] plateauUpperCorner) {
        if (position == null || plateauUpperCorner[0] == 0 || plateauUpperCorner[1] == 0) {
            return false;
        }
        int x = position.getX();
        int y = position.getY();
        return (x >= 0 && x <= plateauUpperCorner[0] && y >= 0 && y <= plateauUpperCorner[1]);
    }
}
