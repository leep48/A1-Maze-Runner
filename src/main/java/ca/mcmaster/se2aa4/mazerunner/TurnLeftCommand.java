package ca.mcmaster.se2aa4.mazerunner;

public class TurnLeftCommand implements Command {
    private Position position;

    public TurnLeftCommand(Position position) {
        this.position = position;
    }

    public void execute() {
        position.changeDirection(TurnMove.LEFT);
    }
}
