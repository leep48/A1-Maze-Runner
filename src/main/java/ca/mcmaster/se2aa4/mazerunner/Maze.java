package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    private static char[][] maze;
    private int totalRows, totalColumns;
    private int entryRow, exitRow;

    // Constructor
    public Maze(int totalRows, int totalColumns, char[][] mazeArray) {
        maze = mazeArray;
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;

        try {
            entryFinder();
            exitFinder();
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }

    /*
    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }
    */

    public void entryFinder() throws Exception {
        for (int row = 0; row < totalRows; row++) {
            if (maze[row][0] != '#') {
                entryRow = row;
                return;
            }
        }
        throw new Exception("No entry found.");
    }

    public void exitFinder() throws Exception {
        for (int row = 0; row < totalRows; row++) {
            if (maze[row][totalColumns - 1] != '#') {
                exitRow = row;
                return;
            }
        }
        throw new Exception("No exit found.");
    }
}
