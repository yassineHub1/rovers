package direction;

import rover.Rover;

public class Nord implements Direction{
    public Direction turnLeft(){
        return new Ouest();
    }

    public Direction turnRight(){
        return new Est();
    }

    @Override
    public void move(Rover rover) {
        rover.incrementY();
    }

}
