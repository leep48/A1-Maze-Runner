package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathValidator {
    private static final Logger logger = LogManager.getLogger();

    public void validatePath(String userPath, Maze maze) {
        logger.info("**** Validating path");

        try {
            logger.debug("Getting entry coordinate...");
            Coordinate startCoordinate = maze.getEntryCoordinate();
            Position currentPosition = new Position(startCoordinate.getRow(), startCoordinate.getColumn());

            logger.debug("Creating command manager...");
            MoveCommandManagerCreator commandManagerCreator = new MoveCommandManagerCreator(new PathProcessor(userPath), currentPosition);
            CommandManager moveCommandManager = commandManagerCreator.createCommandManager();

            logger.debug("Creating manual navigator...");
            ManualNavigator navigator = new ManualNavigator();
            logger.debug("Created new ManualNavigator object");
            navigator.navigateMaze(maze, moveCommandManager, currentPosition);
            logger.debug("Successfully navigated maze.");

            if (navigator.isPathValid()) {
                System.out.print("correct path");
            } else {
                System.out.print("incorrect path");
            }
        } catch (Exception e) {
            logger.info("ERROR: " + e);
        }
    }
}
