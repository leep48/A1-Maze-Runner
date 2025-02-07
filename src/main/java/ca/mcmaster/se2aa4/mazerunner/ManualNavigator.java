package ca.mcmaster.se2aa4.mazerunner;

import java.util.StringTokenizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManualNavigator {
    private Coordinate entryCoordinate, exitCoordinate;
    private Position currentPosition;
    private StringTokenizer tokenizedPath;
    private boolean validPath;

    private static final Logger logger = LogManager.getLogger();
    
    public void navigateMaze(Maze maze, PathProcessor pathProcessor) {
        validPath = false; // Initialize as an invalid path (default)

        entryCoordinate = maze.getEntryCoordinate();
        exitCoordinate = maze.getExitCoordinate();

        if (!pathProcessor.isFactorized()) {
            pathProcessor.toFactorizedForm();
        }

        // Initializing the current position with the entry coordinates
        currentPosition = new Position(entryCoordinate.getRow(), entryCoordinate.getColumn());

        tokenizedPath = pathProcessor.tokenizePath();

        try {
            logger.trace("**** Navigating maze starting at (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");

            while (tokenizedPath.hasMoreTokens()) {
                String move = tokenizedPath.nextToken();
                logger.trace("**** Current position at (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");
    
                if (move.length() == 2) {
                    if (Character.isDigit(move.charAt(0))) {
                        if (move.charAt(1) == 'F') {
                            if (validMoveChecker(maze, Character.getNumericValue(move.charAt(0)))) { // Passes the maze object and the number of spaces moved
                                currentPosition.moveForward(Character.getNumericValue(move.charAt(0)));
                            } else {
                                logger.info("**** Encountered a wall");
                                return; // A wall is encountered
                            }
                        } else if (move.charAt(1) == 'L') {
                            for (int i = 0; i < Character.getNumericValue(move.charAt(0)); i++) {
                                currentPosition.changeDirection(TurnMove.LEFT);
                            }
                        } else if (move.charAt(1) == 'R') {
                            for (int i = 0; i < Character.getNumericValue(move.charAt(0)); i++) {
                                currentPosition.changeDirection(TurnMove.RIGHT);
                            }
                        } else {
                            throw new Exception(); // Illegal move
                        }
                    } else {
                        throw new Exception(); // Illegal move
                    }
                } else if (move.length() == 1) {
                    if (move.charAt(0) == 'F') {
                        if (validMoveChecker(maze, 1)) {
                            currentPosition.moveForward(1);
                        } else {
                            return; // A wall is encountered
                        }
                    } else if (move.charAt(0) == 'L') {
                        currentPosition.changeDirection(TurnMove.LEFT);
                    } else if (move.charAt(0) == 'R'){
                        currentPosition.changeDirection(TurnMove.RIGHT);
                    } else {
                        throw new Exception(); // Illegal move
                    }
                } else {
                    throw new Exception(); // Illegal move
                }
                logger.trace("**** Move successful: " + move);
            }

            logger.trace("**** Final position: (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");

            logger.info("**** Successfully navigated to the end of the given path");

            // Checks if the current position is at the exit coordinates
            if ((currentPosition.getRow() == exitCoordinate.getRow()) && (currentPosition.getColumn() == exitCoordinate.getColumn())) {
                validPath = true;
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occured due to an illegal move /!\\");
            return;
        }
    }

    public boolean isPathValid() {
        return validPath;
    }

    private boolean validMoveChecker(Maze maze, int spaces) {
        Direction currentDirection = currentPosition.getCurrentDirection();
        int row = currentPosition.getRow();
        int col = currentPosition.getColumn();
    
        // Check if the move is in the NORTH or SOUTH direction (vertical movement)
        if (currentDirection == Direction.NORTH || currentDirection == Direction.SOUTH) {
            logger.trace("**** Checking North/South moving " + spaces + " spaces");
            for (int i = 1; i <= spaces; i++) {
                // Check each row based on the current direction (North or South)
                int newRow;

                if (currentDirection == Direction.NORTH) {
                    newRow = row - i;
                } else {
                    newRow = row + i;
                }
                logger.trace("**** Checking Tile at (" + newRow + ", " + col + ")");

                if (maze.getTile(newRow, col) == '#') {
                    return false; // Invalid move if a wall is encountered
                }
            }
        }
        // Check if the move is in the EAST or WEST direction (horizontal movement)
        else if (currentDirection == Direction.EAST || currentDirection == Direction.WEST) {
            logger.trace("**** Checking East/West  moving " + spaces + " spaces");
            for (int i = 1; i <= spaces; i++) {
                // Check each column based on the current direction (East or West)
                int newCol;

                if (currentDirection == Direction.EAST) {
                    newCol = col + i;
                } else {
                    newCol = col - i;
                }
                logger.trace("**** Checking Tile at (" + row + ", " + newCol + ")");

                if (maze.getTile(row, newCol) == '#') {
                    return false; // Invalid move if a wall is encountered
                }
            }
        }
    
        // If no walls were encountered, return true indicating valid move
        return true;
    }
    
}
