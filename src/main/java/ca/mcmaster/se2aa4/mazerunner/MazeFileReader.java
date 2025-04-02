package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeFileReader {
    private static final Logger logger = LogManager.getLogger();

    public Maze readMazeFromFile(String filePath) throws IOException {
        List<String> mazeLines = new ArrayList<>();

        logger.info("**** Reading the maze from file " + filePath);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            mazeLines.add(line);
        }
        logger.debug("Successfully converted maze into String array");

        int totalRows = mazeLines.size();
        int totalColumns = mazeLines.get(0).length();

        logger.debug("This maze has " + totalRows + " rows and " + totalColumns + " columns.");

        char[][] mazeArray = new char[totalRows][totalColumns];

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalColumns; col++) {
                if (mazeLines.get(row).charAt(col) == '#') {
                    logger.trace("WALL ");
                    mazeArray[row][col] = '#';
                } else if (mazeLines.get(row).charAt(col) != '#') {
                    logger.trace("PASS ");
                    mazeArray[row][col] = ' ';
                }
                //System.out.print(mazeArray[row][col]);
            }
            logger.trace(System.lineSeparator());
            //System.out.println();
        }

        reader.close();

        logger.info("**** Successfully read maze from file " + filePath);
        return new Maze(totalRows, totalColumns, mazeArray);
    }
}
