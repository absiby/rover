package mars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Plateau {
    private static int upperCornerX;
    private static int upperCornerY;

    private static String rover1Path;
    private static String rover2Path;

    private static Rover rover1;
    private static Rover rover2;

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Proper Usage is: java -jar rover.jar filename");
            System.exit(0);
        }

        String filename = "../" + args[0];

        try (Scanner sc = new Scanner(new File(filename))) {
            upperCornerX = sc.nextInt();
            upperCornerY = sc.nextInt();

            rover1 = new Rover(new Position(sc.nextInt(), sc.nextInt()), Direction.valueOf(sc.next()));
            rover1Path = sc.next();

            rover2 = new Rover(new Position(sc.nextInt(), sc.nextInt()), Direction.valueOf(sc.next()));
            rover2Path = sc.next();
        } catch (FileNotFoundException e) {
            System.err.println("fichier introuvable : " + args[0]);
        } catch (InputMismatchException e) {
            System.err.println("Donnée invalide");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (rover1 != null && rover1Path != null) {
            try {
                System.out.println(roverNavigator(rover1, rover1Path));
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            } catch (InvalidPathException e) {
                System.err.println(e.getMessage());
            }
        }
        if (rover2 != null && rover2Path != null) {
            try {
                System.out.println(roverNavigator(rover2, rover2Path));
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            } catch (InvalidPathException e) {
                System.err.println(e.getMessage());
            }
        }
    }


    public static String roverNavigator(Rover rover, String path) throws InvalidPathException {
        if (rover == null) {
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
                    if (isValidLocation(position, upperCornerX, upperCornerY)) {
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

    public static boolean isValidLocation(Position position, int upperCornerX, int upperCornerY) {
        if (position == null || upperCornerY == 0 || upperCornerX == 0) {
            return false;
        }
        int x = position.getX();
        int y = position.getY();
        return (x >= 0 && x <= upperCornerX && y >= 0 && y <= upperCornerY);
    }

}