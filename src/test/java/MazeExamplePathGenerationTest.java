import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.AutoNavigator;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeFileReader;
import ca.mcmaster.se2aa4.mazerunner.RightHandNavigator;

import static org.junit.jupiter.api.Assertions.*;

public class MazeExamplePathGenerationTest {

    @Test
    public void straightMazePathGenerationTest() {
        String filePath = "./examples/straight.maz.txt";
        String generatedPath;
        String expectedPath = "4F";

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);
            AutoNavigator autoNav = new RightHandNavigator(maze);
            autoNav.generatePath();
            generatedPath = autoNav.getGeneratedPath();
        } catch (Exception e) {
            generatedPath = null;
        }

        assertTrue(generatedPath.equals(expectedPath));
    }

    @Test
    public void smallMazePathGenerationTest() {
        String filePath = "./examples/small.maz.txt";
        String generatedPath;
        String expectedPath = "F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F " +
                              "R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R " +
                              "2F R 4F R 2F L 2F R 2F L F";

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);
            AutoNavigator autoNav = new RightHandNavigator(maze);
            autoNav.generatePath();
            generatedPath = autoNav.getGeneratedPath();
        } catch (Exception e) {
            generatedPath = null;
        }

        assertTrue(generatedPath.equals(expectedPath));
    }

    @Test
    public void largeMazePathGenerationTest() {
        String filePath = "./examples/large.maz.txt";
        String generatedPath;
        String expectedPath = 
            "F R 8F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 2F L 8F 2L 6F R 2F R 4F 2L 4F L 2F R " +
            "2F R 4F R 8F R 2F L 2F R 2F L 2F 2L 2F R 2F R 2F 2L 4F R 2F L 2F R 2F 2L 2F R 4F R 2F R 2F 2L " +
            "2F L 2F R 2F L 2F R 8F R 4F R 2F R 2F L 2F 2L 2F R 4F R 2F R 2F L 2F R 2F 2L 2F R 2F 2L 4F R 2F " +
            "R 4F 2L 4F R 2F R 6F R 2F L 2F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 4F L 2F R 2F 2L 2F L 2F R 4F R " +
            "4F R 2F R 2F 2L 2F R 4F L 2F 2L 2F R 2F R 4F R 4F R 2F L 2F 2L 2F R 2F R 2F L 4F 2L 4F R 2F R " +
            "2F 2L 2F R 2F R 6F R 2F R 2F 2L 2F R 2F L 6F 2L 6F R 4F R 2F R 2F L 4F 2L 4F R 2F L 2F R 2F 2L " +
            "2F R 6F R 2F R 2F 2L 6F R 4F R 2F R 2F L 6F R 2F 2L 2F L 6F R 2F R 8F R 2F L 2F 2L 2F R 2F R 2F " +
            "2L 2F R 2F R 2F 2L 2F L 2F R 8F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F 2L 2F R 2F L 2F R 2F R 4F R " +
            "2F L 2F 2L 2F R 2F L 2F R 2F R 4F R 2F 2L 4F R 2F R 4F 2L 2F R 2F R 2F 2L 2F R 2F R 4F R 4F 2L 2F " +
            "R 4F L 2F R 2F R 2F L 2F R 2F 2L 2F R 2F L 2F 2L 2F R 4F R 2F R 2F L 2F R 6F L 4F 2L 4F R 2F R 4F " +
            "2L 4F R 2F R 2F 2L 2F R 2F L 2F R 2F R 4F R 2F L 2F R 2F 2L 2F L 2F R 2F R 2F 2L 6F R 2F R 2F 2L 2F " +
            "R 2F 2L 2F R 2F R 4F R 4F R 2F L 2F R 2F L 2F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 2F R 2F 2L " +
            "2F L 2F R 4F R 4F R 2F R 2F 2L 2F R 4F 2L 4F R 2F R 4F L 2F 2L 2F R 4F R 2F R 2F 2L 2F R 2F R 2F 2L " +
            "2F R 2F R 4F R 2F 2L 2F L 4F R 2F R 4F 2L 2F R 2F R 2F L 8F 2L 2F R 2F L 2F 2L 2F R 2F R 6F R 2F R 2F " +
            "2L 4F R 2F R 2F 2L 4F R 2F R 6F R 2F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 4F R 2F R 6F 2L 4F R 2F R 6F 2L " +
            "2F R 2F R 2F 2L 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 6F L 4F 2L 2F R 2F 2L 2F R 2F R 6F L 2F R 2F R " +
            "4F R 4F L 2F R 2F 2L 2F L 2F R 6F R 2F R 4F 2L 4F L 2F L 2F R 4F L 2F R 2F R 2F 2L 2F R 2F R 4F 2L " +
            "2F R 2F R 4F 2L 2F R 2F 2L 2F R 2F R 2F L 2F R 6F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 2F 2L 2F L 2F " +
            "R 2F R 4F R 2F 2L 2F R 4F R 6F R 2F R 4F 2L 4F R 2F R 2F 2L 2F R 2F 2L 4F R 2F R 2F 2L 4F R 2F R 2F " +
            "2L 2F R 2F L 2F R 2F R 4F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F 2L 2F R 2F R 4F L 2F R 2F 2L " +
            "2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 4F 2L 4F L 6F R 2F R 2F 2L 2F L 2F R 2F R 8F R 2F R 4F 2L " +
            "2F R 2F R 2F 2L 4F R 2F 2L 2F L 2F R 2F R 4F 2L 2F R 2F R 4F R 2F 2L 2F L 2F R 2F 2L 2F R 2F R 4F L " +
            "2F R 2F R 2F L 2F 2L 2F R 2F R 4F R 2F L 4F R 6F R 2F R 4F 2L 4F R 2F R 4F 2L 2F R 2F R 2F 2L 2F R 2F " +
            "R 2F 2L 2F L 4F R 2F R 2F 2L 6F R 6F R 2F R 4F 2L 4F L 2F R 4F R 2F R 2F 2L 2F R 2F R 8F 2L 4F R 2F R " +
            "4F 2L 2F R 2F R 2F 2L 2F L 2F R 2F R 4F R 6F R 2F 2L 2F R 4F 2L 4F R 2F R 2F 2L 2F R 2F 2L 4F R 2F R " +
            "2F 2L 2F R 4F L 6F R 2F R 4F 2L 4F R 2F L 4F R 2F R 6F R 2F 2L 4F 2L 2F R 8F R 2F R 4F 2L 6F R 2F " +
            "R 2F 2L 4F R 2F R 2F 2L 2F L 2F R 4F R 4F R 2F R 2F 2L 2F R 2F 2L 4F R 2F R 6F R 2F 2L 2F R 2F R " +
            "4F 2L 4F R 2F R 6F 2L 6F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F 2L 2F R 2F R 4F 2L 6F R 2F R 4F 2L 4F " +
            "R 2F R 2F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 2F L 4F 2L 4F R 2F R 6F 2L 6F R 2F R 8F L 2F R 2F R 2F " +
            "2L 2F R 2F 2L 2F R 2F R 2F 2L 2F L 2F R 2F L 2F R 6F R 2F R 4F L 2F R 2F 2L 2F L 2F R 4F R 2F R 2F " +
            "2L 2F R 2F R 4F 2L 4F L 4F R 2F R 2F 2L 2F L 2F R 2F R 4F R 2F 2L 2F L 2F R 2F R 6F R 2F R 2F L 4F " +
            "R 2F L 4F R 2F R 2F 2L 2F R 8F R 2F L 4F 2L 4F R 4F R 2F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 6F 2L 4F " +
            "R 2F R 2F L 2F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 4F R 2F R 6F R 2F 2L 2F R 4F R 2F R 2F 2L 2F R 2F " +
            "R 2F 2L 4F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 2F R 2F 2L 2F R 12F R 4F R 2F R 2F 2L 2F R 2F R 2F L 4F " +
            "2L 4F R 2F R 6F R 2F 2L 2F R 4F 2L 10F R 2F R 8F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 2F 2L 2F L 2F R " + 
            "2F R 2F 2L 2F L 2F R 4F L 2F R 6F R 2F R 2F 2L 2F L 2F R 2F R 4F R 6F R 2F 2L 2F R 4F 2L 6F R 2F 2L " +
            "2F R 4F L 4F L 2F R 2F R 4F R 2F 2L 4F R 2F R 2F 2L 2F L 2F R 4F R 4F R 2F R 2F 2L 2F R 2F 2L 4F R 2F " +
            "R 2F 2L 4F R 2F R 4F 2L 4F R 4F R 2F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 6F 2L 4F R 2F R 6F 2L 4F R 2F R " +
            "6F 2L 4F R 2F R 4F 2L 2F R 2F R 4F R 2F 2L 2F L 2F R 2F R 6F L 2F R 6F R 2F R 2F 2L 6F 2L 4F R 2F R 4F 2L 12F R F";

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);
            AutoNavigator autoNav = new RightHandNavigator(maze);
            autoNav.generatePath();
            generatedPath = autoNav.getGeneratedPath();
        } catch (Exception e) {
            generatedPath = null;
        }

        assertTrue(generatedPath.equals(expectedPath));
    }
}
