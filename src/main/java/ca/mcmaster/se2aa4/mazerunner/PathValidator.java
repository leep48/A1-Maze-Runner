package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathValidator {
    private static final Logger logger = LogManager.getLogger();
    
    public void validatePath(String userPath) {
        logger.info("**** Validating path");
        if (userPath.equals("F R FF L FFFF R FF L FF")) {
            System.out.println("correct path");
        } else {
            System.out.println("incorrect path");
        }
    }
}
