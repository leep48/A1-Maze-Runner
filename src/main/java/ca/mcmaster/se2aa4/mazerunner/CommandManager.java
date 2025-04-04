package ca.mcmaster.se2aa4.mazerunner;

import java.util.LinkedList;
import java.util.Queue;

public class CommandManager {
    private Queue<Command> commandQueue = new LinkedList<>();

    public void queueCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeNextCommand() {
        if (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
        }
    }

    public boolean hasCommandsAvailable() {
        if (commandQueue.isEmpty()) {
            return false;
        }
        return true;
    }
}
