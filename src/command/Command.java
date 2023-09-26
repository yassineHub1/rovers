package command;

import rover.Rover;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface Command {
    void execute(Rover rover);

    static List<Command> parseCommand(String stringCommands){
        List<Command> commands = new LinkedList<>();
        for(char c : stringCommands.toCharArray()){
            commands.add(LookupCommand.valueOf(String.valueOf(c)).getCommand());
        }
        return commands;
    }

}
