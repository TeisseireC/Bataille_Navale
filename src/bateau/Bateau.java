package bateau;

public class Bateau {

    private int[] startPosition;
    private int modele;
    private String direction;

    public void setStartPosition(int[] startPosition) {
        this.startPosition = startPosition;
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
