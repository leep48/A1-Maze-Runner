package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MoveLogger implements NavigationObserver {
    private static final Logger logger = LogManager.getLogger();

    public void update(RightHandMove move, Position currentPosition) {
        String movesExecuted;
        if (move == RightHandMove.FORWARD) {
            movesExecuted = "F";
        } else if (move == RightHandMove.TURN_LEFT) {
            movesExecuted = "L";
        } else if (move == RightHandMove.FORWARD_TURN_RIGHT) {
            movesExecuted = "F, R";
        } else {
            movesExecuted = "N/A";
        }

        logger.trace("------------------- MOVE LOG -------------------");
        logger.trace("MOVE(S) EXECUTED: " + movesExecuted);
        logger.trace("CURRENT ROW: " + currentPosition.getRow());
        logger.trace("CURRENT COLUMN: " + currentPosition.getColumn());
        logger.trace("CURRENT DIRECTION: " + currentPosition.getCurrentDirection());
    }
}
