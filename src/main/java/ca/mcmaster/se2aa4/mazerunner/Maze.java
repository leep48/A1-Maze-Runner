package ca.mcmaster.se2aa4.mazerunner;

public class Maze {
    private static char[][] maze;
    private int totalRows, totalColumns;

    public Maze(int totalRows, int totalColumns, char[][] mazeArray) {
        maze = mazeArray;
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }
}
