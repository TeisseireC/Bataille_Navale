package Modele.coordonnes;

public class Coordinate {

    private int abscissa;
    private int ordinate;
    final static int ABSCISSA_SIZE = 10;
    final static int ORDINATE_SIZE = 10;

    public Coordinate(int abscissa, int ordinate){
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    public static boolean isCoordonneValid(Coordinate coordinate){
        boolean result = false;
        if ((coordinate.abscissa > 0 && coordinate.ordinate > 0) && (coordinate.abscissa <= ABSCISSA_SIZE && coordinate.ordinate <= ORDINATE_SIZE)){
                result = true;
        }
        return result;
    }

    public int getAbscissa() {
        return abscissa;
    }

    public int getOrdinate() {
        return ordinate;
    }

    @Override
    public boolean equals(Object coordonee) {
        if ((coordonee instanceof Coordinate) && (((Coordinate) coordonee).abscissa == (this.abscissa) && ((Coordinate) coordonee).ordinate == (this.ordinate))) {
            return true;
        } else {
            return false;
        }
    }
}
