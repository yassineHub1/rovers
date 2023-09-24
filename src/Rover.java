public class Rover {
    private int x;
    private int y;
    private char direction;

    public Rover(int x, int y, char direction){
        this.x  = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft(){
        switch(direction){
            case 'N':
                direction = 'W';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'W':
                direction = 'S';
                break;
        }
    }

    public void turnRight(){
        switch(direction){
            case 'N':
                direction = 'E';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }
    public void move(){
        switch(direction){
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
        }
    }
    public void action(char instruction){
        switch (instruction){
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'M':
                move();
                break;
        }
    }


    @Override
    public String toString(){
        return x + " " + y + " " + direction;
    }
}
