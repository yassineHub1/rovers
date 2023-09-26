public class Plateau {
    private int width;
    private int height;

    public Plateau(int width, int height){
        this.width = width;
        this.height = height;
    }
    public static Plateau parsePlateau(String plateauDimensions){
        String[] dimensions = plateauDimensions.split(" ");
        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid plateau dimensions");
        } else {
            return new Plateau(width, height);
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }


}
