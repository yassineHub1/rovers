package direction;

import rover.Rover;

public class Est implements Direction{
    public Direction turnLeft(){
        return new Nord();
    }

    public Direction turnRight(){
        return new Sud();
    }

    @Override
    public void move(Rover rover) {
        rover.incrementX();
    }

    @Override
    public String toString(){
        return "E";
    }
}

