package coordinate;

public class CartesianCoordinate implements Coordinate{
    private int x;
    private int y;

    public CartesianCoordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int getAbssice() {
        return x;
    }

    @Override
    public int getOrdinate() {
        return y;
    }

    @Override
    public void incrementX() {
        x++;
    }

    @Override
    public void incrementY() {
        y++;
    }

    @Override
    public void decrementX() {
        x--;
    }

    public void decrementY() {
        y--;
    }

    @Override
    public String toString(){
        return x + " " + y;
    }
}
