package ca.mcmaster.se2aa4.mazerunner;

public class Coordinate {
    private int row;
    private int column;

    // Constructor
    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Getter Methods
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    // Setter Methods
    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
