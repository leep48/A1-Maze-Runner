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

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        options.addOption("i", true, "specifies the filename to be used");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            // Checks for -i flag
            if(cmd.hasOption("i")) {
                String file = cmd.getOptionValue("i");
                //System.out.println("Testing -i flag");

                logger.info("**** Reading the maze from file " + file);
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            //logger.trace("WALL ");
                            System.out.print("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            //logger.trace("PASS ");
                            System.out.print("PASS ");

                    }
                }
                System.out.print(System.lineSeparator());
            }
            }

            //reader.close();
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
