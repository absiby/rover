package nasa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Plateau {

    private static final Logger LOGGER = Logger.getLogger(Plateau.class.getName());
    private int[] plateauUpperCorner = new int[2];


    private String roverPath;
    private Rover rover;

    public static void main(String[] args) {
        Plateau plateau = new Plateau();

        if (args.length == 0) {
            System.out.println("Proper Usage is: java -jar rover.jar filename");
            System.exit(0);
        }

        String filename = "../" + args[0];

        try (Scanner sc = new Scanner(new File(filename))) {
            plateau.plateauUpperCorner[0] = sc.nextInt();
            plateau.plateauUpperCorner[1] = sc.nextInt();

            while (sc.hasNext()) {
                plateau.rover = new Rover(new Position(sc.nextInt(), sc.nextInt()), Direction.valueOf(sc.next()));
                plateau.roverPath = sc.next();
                String newRoverLocation = RoverNavigator.navigate(plateau.rover, plateau.roverPath, plateau.plateauUpperCorner);
                System.out.println(newRoverLocation);
            }
        } catch (FileNotFoundException|InputMismatchException|InvalidPathException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
        }
    }

}
