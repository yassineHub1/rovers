package direction;


import rover.Rover;

public interface Direction {
    Direction turnLeft();
    Direction turnRight();
    void move(Rover rover);
}
