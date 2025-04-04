package ca.mcmaster.se2aa4.mazerunner;

import java.util.StringTokenizer;

public class MoveCommandManagerCreator {
    private Position position;
    private PathProcessor path;
    
    public MoveCommandManagerCreator(PathProcessor path, Position position) {
        this.path = path;
        this.position = position;
    }

    public CommandManager createCommandManager() throws Exception {
        CommandManager commandManager = new CommandManager();

        if (!path.isFactorized()) {
            path.toFactorizedForm();
        }

        StringTokenizer tokenizedPath = new StringTokenizer(path.getProcessedPath());

        while (tokenizedPath.hasMoreTokens()) {
            String move = tokenizedPath.nextToken();
            int moveCount;

            // Retrieves type of move (F, L, or R)
            char moveType = move.charAt(move.length() - 1);

            // Retrieves amount of times move is executed
            if (move.length() >= 2) {
                moveCount = Integer.parseInt(move.substring(0, move.length() - 1));
            } else {
                moveCount = 1;
            }

            for (int i = 0; i < moveCount; i++) {
                if (moveType == 'F') {
                    commandManager.queueCommand(new MoveForwardCommand(position));
                } else if (moveType == 'L') {
                    commandManager.queueCommand(new TurnLeftCommand(position));
                } else if (moveType == 'R') {
                    commandManager.queueCommand(new TurnRightCommand(position));
                } else {
                    throw new Exception("Invalid move type.");
                }
            }
        }

        return commandManager;
    }
}
