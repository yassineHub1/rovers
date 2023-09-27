import command.Command;
import rover.Rover;
import rover.Plateau;

import java.util.List;
import java.util.Set;

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
                System.out.println(rover);
            }

        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }


    }

    private static void checkRoverInstructions(String roverInstructions) {
        Set<Character> validInstructions = Set.of('L', 'R', 'M');

        for(char instruction : roverInstructions.toCharArray()){
            if(!validInstructions.contains(instruction)){
                throw new IllegalArgumentException("Invalid instruction: " + instruction);
            }
        }
    }

    private static void checkRoverPosition(int x, int y, Plateau plateau) throws Exception{
        if(x < 0 || x > plateau.getWidth() || y < 0 || y > plateau.getHeight()){
            throw new IllegalArgumentException("rover.Rover position is out of bounds");
        }
    }

    private static void checkPlateDimensions(int rows, int columns) throws Exception {
        if(rows < 0 ||  columns < 0){
            throw new Exception("Invalid plate dimensions");
        }
    }
}
