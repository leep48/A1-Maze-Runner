import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.mazerunner.Coordinate;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeFileReader;

public class MazeFileReaderTest {
    
    @Test
    public void straightMazeFileReadTest() {
        MazeFileReader mazeReader = new MazeFileReader();
        Maze maze;
        String filePath = "./examples/straight.maz.txt";
        Coordinate entryCoordinate;
        Coordinate exitCoordinate;
        boolean isEntryCoordinateCorrect;
        boolean isExitCoordinateCorrect;

        try {
            maze = mazeReader.readMazeFromFile(filePath);
            entryCoordinate = maze.getEntryCoordinate();
            exitCoordinate = maze.getExitCoordinate();

            if (entryCoordinate.getRow() == 2 && entryCoordinate.getColumn() == 0) {
                isEntryCoordinateCorrect = true;
            } else {
                isEntryCoordinateCorrect = false;
            }

            if (exitCoordinate.getRow() == 2 && exitCoordinate.getColumn() == 4) {
                isExitCoordinateCorrect = true;
            } else {
                isExitCoordinateCorrect = false;
            }
        } catch (Exception e) {
            isEntryCoordinateCorrect = false;
            isExitCoordinateCorrect = false;
        }
        
        assertTrue(isEntryCoordinateCorrect && isExitCoordinateCorrect);
    }
}
