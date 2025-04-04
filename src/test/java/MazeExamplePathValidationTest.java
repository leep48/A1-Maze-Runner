import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.CommandManager;
import ca.mcmaster.se2aa4.mazerunner.Coordinate;
import ca.mcmaster.se2aa4.mazerunner.ManualNavigator;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeFileReader;
import ca.mcmaster.se2aa4.mazerunner.MoveCommandManagerCreator;
import ca.mcmaster.se2aa4.mazerunner.PathProcessor;
import ca.mcmaster.se2aa4.mazerunner.Position;

import static org.junit.jupiter.api.Assertions.*;

public class MazeExamplePathValidationTest {

    @Test
    public void straightMazeCorrectPathValidationTest() {
        String filePath = "./examples/straight.maz.txt";
        String userInputtedPath = "4F";
        boolean isPathValid;

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);

            Coordinate startCoordinate = maze.getEntryCoordinate();
            Position currentPosition = new Position(startCoordinate.getRow(), startCoordinate.getColumn());

            MoveCommandManagerCreator commandManagerCreator = new MoveCommandManagerCreator(new PathProcessor(userInputtedPath), currentPosition);
            CommandManager moveCommandManager = commandManagerCreator.createCommandManager();

            ManualNavigator navigator = new ManualNavigator();
            navigator.navigateMaze(maze, moveCommandManager, currentPosition);

            isPathValid = navigator.isPathValid();
        } catch (Exception e) {
            isPathValid = false;
        }

        assertTrue(isPathValid);
    }

    @Test
    public void straightMazeWrongPathValidationTest() {
        String filePath = "./examples/straight.maz.txt";
        String userInputtedPath = "5F";
        boolean isPathValid;

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);

            Coordinate startCoordinate = maze.getEntryCoordinate();
            Position currentPosition = new Position(startCoordinate.getRow(), startCoordinate.getColumn());

            MoveCommandManagerCreator commandManagerCreator = new MoveCommandManagerCreator(new PathProcessor(userInputtedPath), currentPosition);
            CommandManager moveCommandManager = commandManagerCreator.createCommandManager();

            ManualNavigator navigator = new ManualNavigator();
            navigator.navigateMaze(maze, moveCommandManager, currentPosition);

            isPathValid = navigator.isPathValid();
        } catch (Exception e) {
            isPathValid = false;
        }

        assertFalse(isPathValid);
    }

    @Test
    public void smallMazeCorrectPathValidationTest() {
        String filePath = "./examples/small.maz.txt";
        String userInputtedPath = "F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F " +
                                  "R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R " +
                                  "2F R 4F R 2F L 2F R 2F L F";
        boolean isPathValid;

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);

            Coordinate startCoordinate = maze.getEntryCoordinate();
            Position currentPosition = new Position(startCoordinate.getRow(), startCoordinate.getColumn());

            MoveCommandManagerCreator commandManagerCreator = new MoveCommandManagerCreator(new PathProcessor(userInputtedPath), currentPosition);
            CommandManager moveCommandManager = commandManagerCreator.createCommandManager();

            ManualNavigator navigator = new ManualNavigator();
            navigator.navigateMaze(maze, moveCommandManager, currentPosition);

            isPathValid = navigator.isPathValid();
        } catch (Exception e) {
            isPathValid = false;
        }

        assertTrue(isPathValid);
    }

    @Test
    public void smallMazeWrongPathValidationTest() {
        String filePath = "./examples/small.maz.txt";
        String userInputtedPath = "F R 2F";
        boolean isPathValid;

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);

            Coordinate startCoordinate = maze.getEntryCoordinate();
            Position currentPosition = new Position(startCoordinate.getRow(), startCoordinate.getColumn());

            MoveCommandManagerCreator commandManagerCreator = new MoveCommandManagerCreator(new PathProcessor(userInputtedPath), currentPosition);
            CommandManager moveCommandManager = commandManagerCreator.createCommandManager();

            ManualNavigator navigator = new ManualNavigator();
            navigator.navigateMaze(maze, moveCommandManager, currentPosition);

            isPathValid = navigator.isPathValid();
        } catch (Exception e) {
            isPathValid = false;
        }

        assertFalse(isPathValid);
    }

    @Test
    public void largeMazeCorrectPathValidationTest() {
        String filePath = "./examples/large.maz.txt";
        String userInputtedPath = 
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
        boolean isPathValid;

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);

            Coordinate startCoordinate = maze.getEntryCoordinate();
            Position currentPosition = new Position(startCoordinate.getRow(), startCoordinate.getColumn());

            MoveCommandManagerCreator commandManagerCreator = new MoveCommandManagerCreator(new PathProcessor(userInputtedPath), currentPosition);
            CommandManager moveCommandManager = commandManagerCreator.createCommandManager();

            ManualNavigator navigator = new ManualNavigator();
            navigator.navigateMaze(maze, moveCommandManager, currentPosition);

            isPathValid = navigator.isPathValid();
        } catch (Exception e) {
            isPathValid = false;
        }

        assertTrue(isPathValid);
    }

    @Test
    public void largeMazeWrongPathValidationTest() {
        String filePath = "./examples/large.maz.txt";
        String userInputtedPath = "F R 8F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 2F L 8F 2L 6F R 2F R 4F 2L 4F L 2F";
        boolean isPathValid;

        try {
            MazeFileReader mazeReader = new MazeFileReader();
            Maze maze = mazeReader.readMazeFromFile(filePath);

            Coordinate startCoordinate = maze.getEntryCoordinate();
            Position currentPosition = new Position(startCoordinate.getRow(), startCoordinate.getColumn());

            MoveCommandManagerCreator commandManagerCreator = new MoveCommandManagerCreator(new PathProcessor(userInputtedPath), currentPosition);
            CommandManager moveCommandManager = commandManagerCreator.createCommandManager();

            ManualNavigator navigator = new ManualNavigator();
            navigator.navigateMaze(maze, moveCommandManager, currentPosition);

            isPathValid = navigator.isPathValid();
        } catch (Exception e) {
            isPathValid = false;
        }

        assertFalse(isPathValid);
    }
    
}