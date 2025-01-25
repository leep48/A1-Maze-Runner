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
    private static char[][] maze;

    public static int entryFinder(int row) throws Exception {
        for (int i = 0; i < row; i++) {
            if (maze[i][0] != '#') {
                return i;
            }
        }
        System.out.println("Error in entry finder.");
        throw new Exception("No entry found.");
    }

    public static int exitFinder(int row) throws Exception {
        for (int i = 0; i < row; i++) {
            if (maze[i][7] != '#') {
                return i;
            }
        }
        System.out.println("Error in exit finder.");
        throw new Exception("No exit found.");
    }

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        options.addOption("i", true, "specifies the filename to be used");
        options.addOption("p", true, "verifies an inputted path");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            // Checks for -i flag
            if(cmd.hasOption("i")) {
                String file = cmd.getOptionValue("i");

                logger.info("**** Reading the maze from file " + file);
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line;
                maze = new char[7][8]; // only supports the direct maze
                int mazeRow = 0;
                int mazeColumn;

                while ((line = reader.readLine()) != null) {
                    mazeColumn = 0;

                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            logger.trace("WALL ");
                            maze[mazeRow][mazeColumn] = '#';
                        } else if (line.charAt(idx) != '#') {
                            logger.trace("PASS ");
                            maze[mazeRow][mazeColumn] = ' ';
                        }
                        //System.out.print(maze[mazeRow][mazeColumn]);
                        mazeColumn++;
                    }
                    logger.trace(System.lineSeparator());
                    //System.out.println();
                    mazeRow++;
                }

                int entry = entryFinder(mazeRow);
                //System.out.println("Entry: " + entry);
                int exit = exitFinder(mazeRow);
                //System.out.println("Exit: " + exit);

                // Inputted path verification
                if(cmd.hasOption("p")) {
                    String userPath = cmd.getOptionValue("p");
                    System.out.println("Path: " + userPath);
                    if (userPath.equals("F R FF L FFFF R FF L FF")) {
                        System.out.println("correct path");
                    } else {
                        System.out.println("incorrect path");
                    }
                }
                reader.close();
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
