package ca.mcmaster.se2aa4.mazerunner;

import java.util.StringTokenizer;
import java.util.regex.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathProcessor {
    private String path;
    private static final Logger logger = LogManager.getLogger();

    public PathProcessor(String path) {
        this.path = path;
    }

    public StringTokenizer tokenizePath() {
        return new StringTokenizer(path);
    }

    public boolean isFactorized() {
        if (path.matches(".*\\d.*")) { // Classifies a path as factorized if it contains at least one digit
            return true;
        }
        return false;
    }

    public void toFactorizedForm() {
        if (path == null || path.isEmpty()) {
            logger.error("**** Error: Path is null or empty!");
            return;
        }
    
        logger.info("**** Original path before factorization: " + path);
        
        StringBuilder factorizedPath = new StringBuilder();
        path = path.replace(" ", ""); // Remove spaces before processing
        int length = path.length();
        int count = 1;
    
        for (int i = 0; i < length; i++) {
            char currentChar = path.charAt(i);
            
            if (i < length - 1 && path.charAt(i + 1) == currentChar) {
                count++;
            } else {
                if (count > 1) {
                    factorizedPath.append(count).append(currentChar);
                } else {
                    factorizedPath.append(currentChar);
                }
    
                if (i < length - 1) { // Avoid trailing space
                    factorizedPath.append(" ");
                }
    
                count = 1;
            }
        }
    
        path = factorizedPath.toString();
        logger.info("**** Factorized path: " + path);
    }
    
}
