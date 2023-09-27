import command.Command;
import rover.Rover;
import rover.Plateau;

import java.util.List;
import java.util.Set;

import static utils.Utils.checkRoverPosition;
import static utils.Utils.parseAndCheckInputfile;

public class Main {
    public static void main(String[] args){
        if(args.length != 1){
            // Throw Illegal argument exception.
            throw new IllegalArgumentException("Please provide a valid input file");
        }
        try{

            List<String> inputFile = parseAndCheckInputfile(args[0]);
            Plateau plateau = Plateau.parsePlateau(inputFile.get(0));

            List<String> roverInput = inputFile.subList(1, inputFile.size());
            
            for(int i = 0; i < roverInput.size(); i+=2){
                Rover rover = Rover.createRover(roverInput.get(i));
                List<Command> commands = Command.parseCommand(roverInput.get(i+1));
                rover.execute(commands);
                rover.checkRoverPosition(plateau);

                System.out.println(rover);
            }

        } catch(Exception e){
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }


    }


}
