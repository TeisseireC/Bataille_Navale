package coordonnes;

public class Coordonnes {

    private int abscisse;
    private int ordonnee;

    public Coordonnes(int abscisse, int ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    @Override
    public boolean equals(Object coordonee) {
        if ((coordonee instanceof Coordonnes) && (((Coordonnes) coordonee).getAbscisse() == (this.abscisse) && ((Coordonnes) coordonee).getOrdonnee() == (this.ordonnee))) {
            return true;
        } else {
            return false;
        }
    }
}
