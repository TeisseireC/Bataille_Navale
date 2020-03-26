package bateau;

public class Bateau {

    private int[] startPosition = new int[2];
    private int model;
    private String direction;

    public Bateau (int x, int y, int model, String direction){
        setDirection(direction);
        setModel(model);
        setStartPosition(x, y);
    }

    public void setStartPosition(int x, int y) {
        this.startPosition[0] = x;
        this.startPosition[1] = y;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int[] getStartPosition() {
        return startPosition;
    }

    public int getModel() {
        return model;
    }

    public String getDirection() {
        return direction;
    }
}
