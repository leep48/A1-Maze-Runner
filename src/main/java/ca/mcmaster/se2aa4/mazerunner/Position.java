package ca.mcmaster.se2aa4.mazerunner;

public class Position extends Coordinate {
    private Direction currentDirection;
    // Constructor
    public Position(int row, int column) {
        super(row, column);
        currentDirection = Direction.EAST; // Default direction
    }

    public void changeDirection(TurnMove turn) {
        if (currentDirection == Direction.EAST) {
            if (turn == TurnMove.LEFT) {
                currentDirection = Direction.NORTH;
            } else if (turn == TurnMove.RIGHT) {
                currentDirection = Direction.SOUTH;
            }
        } else if (currentDirection == Direction.WEST) {
            if (turn == TurnMove.LEFT) {
                currentDirection = Direction.SOUTH;
            } else if (turn == TurnMove.RIGHT) {
                currentDirection = Direction.NORTH;
            }
        } else if (currentDirection == Direction.NORTH) {
            if (turn == TurnMove.LEFT) {
                currentDirection = Direction.WEST;
            } else if (turn == TurnMove.RIGHT) {
                currentDirection = Direction.EAST;
            }
        } else if (currentDirection == Direction.SOUTH) {
            if (turn == TurnMove.LEFT) {
                currentDirection = Direction.EAST;
            } else if (turn == TurnMove.RIGHT) {
                currentDirection = Direction.WEST;
            }
        }
    }

    public void moveForward(int spaces) {
        if (currentDirection == Direction.NORTH) {
            super.setRow(super.getRow() - spaces);
        } else if (currentDirection == Direction.SOUTH) {
            super.setRow(super.getRow() + spaces);
        } else if (currentDirection == Direction.EAST) {
            super.setColumn(super.getColumn() + spaces);
        } else if (currentDirection == Direction.WEST) {
            super.setColumn(super.getColumn() - spaces);
        }        
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }
}
