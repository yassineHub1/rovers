package direction;

import rover.Rover;

public class Ouest implements Direction{
    public Direction turnLeft(){
        return new Sud();
    }

    public Direction turnRight(){
        return new Nord();
    }

    @Override
    public void move(Rover rover) {
        rover.decrementX();
    }

    @Override
    public String toString(){
        return "0";
    }
}
