package Modele.bateau;

import Modele.coordonnes.Coordonnes;
import Modele.coordonnes.Direction;

import java.util.ArrayList;
import java.util.List;

public class Bateau {

    private List<Coordonnes> coordonnes = new ArrayList<>();
    private int taille;

    public Bateau (Coordonnes startPosition,int taille, Direction direction){
        this.coordonnes.add(startPosition);
        this.taille = taille;
        setAllCoodinate(direction);
    }

    private void setAllCoodinate(Direction direction){
        int startAbscisse = this.coordonnes.get(0).getAbscisse();
        int startOrdonnee = this.coordonnes.get(0).getOrdonnee();

        for (int i=1; i<this.taille; i++){
            switch (direction){
                case HAUT : this.coordonnes.add(new Coordonnes(startAbscisse , startOrdonnee - i));
                    break;
                case BAS:  this.coordonnes.add(new Coordonnes(startAbscisse , startOrdonnee + i));
                    break;
                case GAUCHE:  this.coordonnes.add(new Coordonnes(startAbscisse - i , startOrdonnee));
                    break;
                case DROITE:  this.coordonnes.add(new Coordonnes(startAbscisse + i , startOrdonnee));
                    break;
            }
        }

    }

    public boolean isOnCoordinate(Coordonnes coordonnee) {
        return this.coordonnes.contains(coordonnee);
    }

    // Risqué mais je ne vois pas comment faire
    public List<Coordonnes> getCoordonnes(){
        return this.coordonnes;
    }

    public int getTaille(){
        return this.taille;
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
