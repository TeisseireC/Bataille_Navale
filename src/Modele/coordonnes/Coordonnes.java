package Modele.coordonnes;

import java.util.List;

public class Coordonnes {

    private int abscisse;
    private int ordonnee;
    final static int TAILLE_ABSCISSE = 10;
    final static int TAILLE_ORDONNEE = 10;

    public Coordonnes(int abscisse, int ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public static boolean isCoordonneValid(Coordonnes coordonnes){
        boolean result = false;
        if ((coordonnes.abscisse > 0 && coordonnes.ordonnee > 0) && (coordonnes.abscisse <= TAILLE_ABSCISSE && coordonnes.ordonnee <= TAILLE_ORDONNEE)){
                result = true;
        }
        return result;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    @Override
    public boolean equals(Object coordonee) {
        if ((coordonee instanceof Coordonnes) && (((Coordonnes) coordonee).abscisse == (this.abscisse) && ((Coordonnes) coordonee).ordonnee == (this.ordonnee))) {
            return true;
        } else {
            return false;
        }
    }
}
