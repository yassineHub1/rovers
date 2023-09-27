package rover;

import command.Command;
import coordinate.CartesianCoordinate;
import coordinate.Coordinate;
import direction.Direction;
import direction.TranslateCharDirection;

import java.util.List;

public class Rover {
    private Coordinate coordinate;
    private Direction direction;

    public Rover(Coordinate coordinate, Direction direction){
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public void turnLeft(){
        this.direction = this.direction.turnLeft();
    }

    public void turnRight(){
        this.direction = this.direction.turnRight();
    }
    public void move(){
        this.direction.move(this);
    }


    public static Rover createRover(String position){
        String[] positionArray = position.split(" ");
        int x = Integer.parseInt(positionArray[0]);
        int y = Integer.parseInt(positionArray[1]);
        Direction direction = TranslateCharDirection.valueOf(positionArray[2]).getDirection();
        Coordinate coordinate = new CartesianCoordinate(x, y);
        return new Rover(coordinate, direction);
    }

    public void incrementX(){
        this.coordinate.incrementX();
    }

    public void incrementY(){
        this.coordinate.incrementY();
    }

    public void decrementX(){
        this.coordinate.decrementX();
    }

    public void decrementY(){
        this.coordinate.decrementY();
    }

    @Override
    public String toString() {
        return this.coordinate.toString() + " " + this.direction.toString();
    }

    public void execute(List<Command> commands){
        for (Command command : commands){
            command.execute(this);
        }
    }


}
