package command;

import rover.Rover;

public class TurnRight implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnRight();
    }
}

