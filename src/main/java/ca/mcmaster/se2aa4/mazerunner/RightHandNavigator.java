package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandNavigator implements AutoNavigator{
    private Maze maze;
    private Coordinate entryCoordinate, exitCoordinate;
    private Position currentPosition;
    private Direction direction;
    private String generatedFactorizedPath;
    private List<NavigationObserver> observers = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger();

    public RightHandNavigator(Maze maze) {
        this.maze = maze;
        entryCoordinate = maze.getEntryCoordinate();
        exitCoordinate = maze.getExitCoordinate();
    }

    public void addObserver(NavigationObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(RightHandMove move) {
        for (NavigationObserver obs : observers) {
            obs.update(move, currentPosition);
        }
    }

    @Override
    public void generatePath() {
        logger.info("**** Generating path using Right Hand algorithm");
        currentPosition = new Position(entryCoordinate.getRow(), entryCoordinate.getColumn());
        
        RightHandMove nextMove = null;
        StringBuilder rawPath = new StringBuilder();

        logger.debug("Generating path from (" + entryCoordinate.getRow() + ", " + entryCoordinate.getColumn() + ") to ("  + exitCoordinate.getRow() + ", " + exitCoordinate.getColumn() + ").");

        while ((currentPosition.getRow() != exitCoordinate.getRow()) || (currentPosition.getColumn() != exitCoordinate.getColumn())) {
            //logger.trace("**** Loop");
            nextMove = determineNextMove();
            if (nextMove == RightHandMove.FORWARD) {
                currentPosition.moveForward(1);
                rawPath.append('F');
            } else if (nextMove == RightHandMove.TURN_LEFT) {
                currentPosition.changeDirection(TurnMove.LEFT);
                rawPath.append('L');
            } else if (nextMove == RightHandMove.FORWARD_TURN_RIGHT) {
                currentPosition.moveForward(1);
                currentPosition.changeDirection(TurnMove.RIGHT);
                rawPath.append('F');
                rawPath.append('R');
            }
            notifyObservers(nextMove);
        }

        PathProcessor pathProcessor = new PathProcessor(rawPath.toString());
        pathProcessor.toFactorizedForm();
        generatedFactorizedPath = pathProcessor.getProcessedPath();
    }

    public String getGeneratedPath() {
        return generatedFactorizedPath;
    }

    private RightHandMove determineNextMove() {
        char frontTile;
        char frontRightTile;
        direction = currentPosition.getCurrentDirection();

        if (direction == Direction.NORTH) {
            frontTile = maze.getTile(currentPosition.getRow() - 1, currentPosition.getColumn());
            frontRightTile = maze.getTile(currentPosition.getRow() - 1, currentPosition.getColumn() + 1);
        } else if (direction == Direction.SOUTH) {
            frontTile = maze.getTile(currentPosition.getRow() + 1, currentPosition.getColumn());
            frontRightTile = maze.getTile(currentPosition.getRow() + 1, currentPosition.getColumn() - 1);
        } else if (direction == Direction.EAST) {
            frontTile = maze.getTile(currentPosition.getRow(), currentPosition.getColumn() + 1);
            frontRightTile = maze.getTile(currentPosition.getRow() + 1, currentPosition.getColumn() + 1);
        } else { // If direction is west
            frontTile = maze.getTile(currentPosition.getRow(), currentPosition.getColumn() - 1);
            frontRightTile = maze.getTile(currentPosition.getRow() - 1, currentPosition.getColumn() - 1);
        }

        if (frontTile == '#') {
            return RightHandMove.TURN_LEFT;
        } else if (frontRightTile == '#') {
            return RightHandMove.FORWARD;
        } else {
            return RightHandMove.FORWARD_TURN_RIGHT;
        }
    }

}
