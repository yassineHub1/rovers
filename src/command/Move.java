package command;

import rover.Rover;

public class Move implements Command {
    @Override
    public void execute(Rover rover) {
        rover.move();
    }
}

