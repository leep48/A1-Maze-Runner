package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static Options options = new Options();
    private static MazeFileReader mazeReader = new MazeFileReader();
    private static Maze maze;

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        // Command line flag options
        options.addOption("i", true, "specifies the filename to be used");
        options.addOption("p", true, "verifies an inputted path");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            // Checks for -i flag
            if(cmd.hasOption("i")) {
                String file = cmd.getOptionValue("i");

                maze = mazeReader.readMazeFromFile(file);

                // Inputted path verification
                if(cmd.hasOption("p")) {
                    logger.info("**** Validating path");
                    String userPath = cmd.getOptionValue("p");
                    PathValidator pathValidator = new PathValidator();
                    pathValidator.validatePath(userPath, maze);
                } else {
                    logger.info("**** Computing path");
                    AutoNavigator autoNav = new RightHandNavigator(maze);
                    autoNav.addObserver(new MoveLogger());
                    autoNav.generatePath();
                    System.out.print(autoNav.getGeneratedPath());
                }
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("** End of MazeRunner");
    }
}
