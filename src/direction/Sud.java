package direction;

import rover.Rover;

public class Sud implements Direction{
    public Direction turnLeft(){
        return  new Est();
    }

    public Direction turnRight(){
        return new Ouest();
    }

    @Override
    public void move(Rover rover) {
        rover.decrementY();
    }
}
