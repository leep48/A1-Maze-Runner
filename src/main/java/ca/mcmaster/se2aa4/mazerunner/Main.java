package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static Options options = new Options();
    private static MazeFileReader mazeReader = new MazeFileReader();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Maze maze;

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
                    String userPath = cmd.getOptionValue("p");
                    System.out.println("Path: " + userPath);
                    PathValidator pathValidator = new PathValidator();
                    pathValidator.validatePath(userPath, maze);
                }
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
