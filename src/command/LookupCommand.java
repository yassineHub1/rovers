package command;

public enum LookupCommand {
    L(new TurnLeft()), R(new TurnRight()), M(new Move());

    private Command command;
    LookupCommand(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
