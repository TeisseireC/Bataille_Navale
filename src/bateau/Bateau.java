package bateau;

import coordonnes.Coordonnes;

public class Bateau {

    private Coordonnes startPosition;
    private int model;
    private String direction;

    public Bateau (int x, int y, int model, String direction){
        setCoordonnes(new Coordonnes(x,y));
        setDirection(direction);
        setModel(model);
    }

    public void setModel(int model) {
        this.model = model;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setCoordonnes(Coordonnes coordonnes){
        this.startPosition = coordonnes;
    }

    public Coordonnes getStartPosition() {
        return startPosition;
    }

    public int getModel() {
        return model;
    }

    public String getDirection() {
        return direction;
    }
}
