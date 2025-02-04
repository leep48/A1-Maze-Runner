package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathValidator {
    private static final Logger logger = LogManager.getLogger();
    private PathProcessor pathProcessor;

    public void validatePath(String userPath, Maze maze) {
        logger.info("**** Validating path");

        pathProcessor = new PathProcessor(userPath);

        ManualNavigator navigator = new ManualNavigator();
        navigator.navigateMaze(maze, pathProcessor);

        if (navigator.isPathValid()) {
            System.out.println("correct path");
        } else {
            System.out.println("incorrect path");
        }
    }
}
