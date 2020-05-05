package Controlleur;

import Modele.bateau.Bateau;
import Modele.bateau.Flotte;
import Modele.coordonnes.Coordonnes;

import java.util.ArrayList;
import java.util.List;

public class Controlleur {
    int tailleAbscisse = 10;
    int tailleOrdonnee = 10;

    // Vérification des coordonnées
    public boolean isStartCoordonneValid(Coordonnes coordonnes){
        boolean result = false;
        if (coordonnes.getAbscisse() > 0 && coordonnes.getOrdonnee() > 0){
            if(coordonnes.getAbscisse() <= tailleAbscisse && coordonnes.getOrdonnee() <= tailleOrdonnee){
                result = true;
            }
        }
        return result;
    }

    //Verification placement bateaux
    public boolean isBoatCanBePlace(List<Bateau> oldBoats,Bateau newBoat){
        boolean result = true;
        if (oldBoats.size() != 0){
            for (int i=0; i<oldBoats.size(); i++){
                for (int j=0; j<newBoat.getTaille(); j++){
                    if(oldBoats.get(i).isOnCoordinate(newBoat.getCoordonnes().get(j))){
                        result = false;
                    }
                }
            }
        }
        return result;
    }
}
