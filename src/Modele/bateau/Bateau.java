package Modele.bateau;

import Exceptions.IllegalCoordinate;
import Modele.coordonnes.Coordonnes;
import Modele.coordonnes.Direction;

import java.util.ArrayList;
import java.util.List;

public class Bateau {

    private List<Coordonnes> coordonnes = new ArrayList<>();
    private int taille;

    public Bateau (Coordonnes startPosition,int taille, Direction direction) throws IllegalCoordinate {
        this.coordonnes.add(startPosition);
        this.taille = taille;

        try {
            setAllCoodinate(direction);
        } catch (IllegalCoordinate illegalCoordinate) {
            throw new IllegalCoordinate();
        }
    }

    private void setAllCoodinate(Direction direction) throws IllegalCoordinate {
        int startAbscisse = this.coordonnes.get(0).getAbscisse();
        int startOrdonnee = this.coordonnes.get(0).getOrdonnee();

        for (int i=1; i<this.taille; i++){
            switch (direction){
                case HAUT :
                    if (startOrdonnee - i < 1){
                        throw new IllegalCoordinate();
                    }
                    this.coordonnes.add(new Coordonnes(startAbscisse , startOrdonnee - i));
                    break;
                case BAS:
                    if (startOrdonnee + i > 10){
                        throw new IllegalCoordinate();
                    }
                    this.coordonnes.add(new Coordonnes(startAbscisse , startOrdonnee + i));
                    break;
                case GAUCHE:
                    if (startAbscisse - i < 1){
                        throw new IllegalCoordinate();
                    }
                    this.coordonnes.add(new Coordonnes(startAbscisse - i , startOrdonnee));
                    break;
                case DROITE:
                    if (startAbscisse + i > 10){
                        throw new IllegalCoordinate();
                    }
                    this.coordonnes.add(new Coordonnes(startAbscisse + i , startOrdonnee));
                    break;
            }
        }
    }

    public int getTaille(){
        return this.taille;
    }

    public boolean isCrossOverBoat(Bateau newBoat){
        boolean result = true;

        for (int i=0; i<newBoat.coordonnes.size(); i++) {
            if (Coordonnes.isCoordonneValid(newBoat.coordonnes.get(i))) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object boat) {
        if ((boat instanceof Bateau) && (((Bateau) boat).taille == (this.taille) && ((Bateau) boat).coordonnes == (this.coordonnes))) {
            return true;
        } else {
            return false;
        }
    }
}
