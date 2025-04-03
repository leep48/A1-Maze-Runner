import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.PathProcessor;

import static org.junit.jupiter.api.Assertions.*;

public class PathProcessorTest {

    @Test
    public void simplePathToFactorizedFormTest() {
        String canonicalPath = "F F F F";
        PathProcessor pathProcessor = new PathProcessor(canonicalPath);
        pathProcessor.toFactorizedForm();
        String factorizedPath = pathProcessor.getProcessedPath();
        assertTrue(factorizedPath.equals("4F"));
    }

    @Test
    public void complexPathToFactorizedFormTest() {
        String canonicalPath = "F F F F F F F F F F F L L F R F F R";
        PathProcessor pathProcessor = new PathProcessor(canonicalPath);
        pathProcessor.toFactorizedForm();
        String factorizedPath = pathProcessor.getProcessedPath();
        assertTrue(factorizedPath.equals("11F 2L F R 2F R"));
    }

    @Test
    public void emptyPathToFactorizedFormTest() {
        String canonicalPath = "";
        PathProcessor pathProcessor = new PathProcessor(canonicalPath);
        pathProcessor.toFactorizedForm();
        String factorizedPath = pathProcessor.getProcessedPath();
        assertTrue(factorizedPath.equals(""));
    }

    @Test
    public void isNotFactorizedTest() {
        String canonicalPath = "F F F R F F L F";
        PathProcessor pathProcessor = new PathProcessor(canonicalPath);
        boolean isPathFactorized = pathProcessor.isFactorized();
        assertTrue(!isPathFactorized);
    }

    @Test
    public void isFactorizedTest() {
        String factorizedPath = "3F 2L 2F R F";
        PathProcessor pathProcessor = new PathProcessor(factorizedPath);
        boolean isPathFactorized = pathProcessor.isFactorized();
        assertTrue(isPathFactorized);
    }
}
