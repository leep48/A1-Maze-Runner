package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManualNavigator {
    private Coordinate exitCoordinate;
    private boolean validPath;

    private static final Logger logger = LogManager.getLogger();
    
    public void navigateMaze(Maze maze, CommandManager moveCommandManager, Position currentPosition) {
        validPath = false; // Initialize as an invalid path (default)
        exitCoordinate = maze.getExitCoordinate();

        logger.trace("**** Navigating maze starting at (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");

        while (moveCommandManager.hasCommandsAvailable()) {
            moveCommandManager.executeNextCommand();
            logger.trace("**** Current position at (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");
            if (!isMoveValid(maze, currentPosition)) {
                return;
            }
        }
        logger.trace("**** Final position: (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");

        logger.info("**** Successfully navigated to the end of the given path");

        // Checks if the current position is at the exit coordinates
        if ((currentPosition.getRow() == exitCoordinate.getRow()) && (currentPosition.getColumn() == exitCoordinate.getColumn())) {
            validPath = true;
        }
    }

    private boolean isMoveValid(Maze maze, Position currentPosition) {
        char currentTile = maze.getTile(currentPosition.getRow(), currentPosition.getColumn());

        if (currentTile == '#') {
            logger.debug("Encountered a wall at (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");
            return false;
        }
        return true;
    }

    public boolean isPathValid() {
        return validPath;
    }
}
