import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;


public class Main {
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Invalid number of arguments, one input file is required");
        }
        try{

            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            String[] plateDimensions = reader.readLine().split(" ");
            int width = Integer.parseInt(plateDimensions[0]);
            int height = Integer.parseInt(plateDimensions[1]);

            checkPlateDimensions(width, height);

            Plateau plateau = new Plateau(width, height);

            while(reader.ready()){

                String[] roverPosition = reader.readLine().split(" ");
                int x = Integer.parseInt(roverPosition[0]);
                int y = Integer.parseInt(roverPosition[1]);
                char direction = roverPosition[2].charAt(0);


                checkRoverPosition(x, y, plateau);
                Rover rover = new Rover(x, y, direction);


                String roverInstructions = reader.readLine();
                checkRoverInstructions(roverInstructions);

                for(char instruction : roverInstructions.toCharArray()){
                    rover.action(instruction);
                }

                System.out.println(rover);
            }

            reader.close();

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
            throw new IllegalArgumentException("Rover position is out of bounds");
        }
    }

    private static void checkPlateDimensions(int rows, int columns) throws Exception {
        if(rows < 0 ||  columns < 0){
            throw new Exception("Invalid plate dimensions");
        }
    }
}
