package direction;

public enum TranslateCharDirection {

    N(new Nord()), E(new Est()), S(new Sud()), O(new Ouest());

    private Direction direction;
    TranslateCharDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection(){
        return direction;
    }
}
