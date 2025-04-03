import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Position;
import ca.mcmaster.se2aa4.mazerunner.TurnMove;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    
    @Test
    public void moveForwardTest() {
        Position currentPosition = new Position(0, 0); // Direction is initialized to East by default
        currentPosition.moveForward(3);
        assertTrue(currentPosition.getCurrentDirection() == Direction.EAST && currentPosition.getRow() == 0 && currentPosition.getColumn() == 3);
    }

    @Test
    public void changeDirectionTest() {
        Position currentPosition = new Position(0, 0); // Direction is initialized to East by default
        currentPosition.changeDirection(TurnMove.RIGHT);
        assertTrue(currentPosition.getCurrentDirection() == Direction.SOUTH && currentPosition.getRow() == 0 && currentPosition.getColumn() == 0);
    }
}
