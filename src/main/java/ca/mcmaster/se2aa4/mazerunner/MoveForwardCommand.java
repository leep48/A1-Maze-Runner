package ca.mcmaster.se2aa4.mazerunner;

public class MoveForwardCommand implements Command {
    private Position position;

    public MoveForwardCommand(Position position) {
        this.position = position;
    }

    public void execute() {
        position.moveForward(1);
    }
}
