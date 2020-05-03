package nasa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Plateau {
    private static int[] plateauUpperCorner = new int[2];

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
            plateauUpperCorner[0] = sc.nextInt();
            plateauUpperCorner[1] = sc.nextInt();

            rover1 = new Rover(new Position(sc.nextInt(), sc.nextInt()), Direction.valueOf(sc.next()));
            rover1Path = sc.next();

            rover2 = new Rover(new Position(sc.nextInt(), sc.nextInt()), Direction.valueOf(sc.next()));
            rover2Path = sc.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Donnée invalide");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (rover1 != null && rover1Path != null) {
            try {
                System.out.println(RoverNavigator.navigate(rover1, rover1Path, plateauUpperCorner));
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            } catch (InvalidPathException e) {
                System.err.println(e.getMessage());
            }
        }
        if (rover2 != null && rover2Path != null) {
            try {
                System.out.println(RoverNavigator.navigate(rover2, rover2Path, plateauUpperCorner));
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            } catch (InvalidPathException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
