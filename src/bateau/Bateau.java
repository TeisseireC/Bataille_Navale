package bateau;

public class Bateau {

    private int[] startPosition = new int[2];
    private int modele;
    private String direction;

    public Bateau (int x, int y, int modele, String direction){
        setDirection(direction);
        setModele(modele);
        setStartPosition(x, y);
    }

    public void setStartPosition(int x, int y) {
        this.startPosition[0] = x;
        this.startPosition[1] = y;
    }

    public void setModele(int modele) {
        this.modele = modele;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int[] getStartPosition() {
        return startPosition;
    }

    public int getModele() {
        return modele;
    }

    public String getDirection() {
        return direction;
    }
}
