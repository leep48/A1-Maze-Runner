package ca.mcmaster.se2aa4.mazerunner;

public class TurnRightCommand implements Command {
    private Position position;

    public TurnRightCommand(Position position) {
        this.position = position;
    }

    public void execute() {
        position.changeDirection(TurnMove.RIGHT);
    }
}
