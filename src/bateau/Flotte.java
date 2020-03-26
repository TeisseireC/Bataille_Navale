package bateau;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private List<Bateau> flotte = new ArrayList<>();

    public String addBateau(Bateau bateau){
        String resultat = "";

        if (verifyModele(bateau.getModele())){
            if (verifyCoord(bateau.getStartPosition()[0], bateau.getStartPosition()[1], bateau.getModele(), bateau.getDirection())){
                flotte.add(bateau);
                resultat = "Bateau ajouté";
            }else{
                resultat = "La position du bateau est incorrecte";
            }
        }else{
            resultat = "Bateau de longueur "+bateau.getModele()+" déjà existant";
        }

        return resultat;
    }

    public boolean verifyModele(int modele){
        boolean canAdd = true; // Variable pour voir si on peux ajouter

        if (flotte.size() < 5) { // Si la flotte n'est pas pleine
            int tmpModeleCount = 0; // Variable qui compte le nombre de bateaux de longueur 2
            for (int i = 0; i < flotte.size(); i++) {    // Parcours de la flotte
                if (modele == 2) {   // Si on veux ajouter un bateau de longueur 2
                    if (flotte.get(i).getModele() == 2) {   // On compte le nombre de bateaux de longueur 2 déjà présent
                        tmpModeleCount++;
                    }
                    if (tmpModeleCount >= 2) { // Si il y en a déjà 2 alors on ne peux pas rajouter
                        canAdd = false;
                    }
                } else {  // Si on veux ajouter un bateau d'une autre longueur
                    if (flotte.get(i).getModele() == modele) {   // Vérification que le bateau de cette longueur n'existe pas
                        canAdd = false;
                    }
                }
            }
        }else{
            canAdd = false;
        }

        return canAdd;
    }

    public boolean verifyCoord(int x,int y,int modele, String direction){
        boolean canAdd = true;

        switch (direction) {
            case "Haut":
                if (y - modele < 1 || (x<1 || x>10)) {
                    canAdd = false;
                }
                break;
            case "Bas":
                if (y + modele > 10 || (x<1 || x>10)) {
                    canAdd = false;
                }
                break;
            case "Gauche":
                if (x - modele < 1 || (y<1 || y>10)) {
                    canAdd = false;
                }
                break;
            case "Droite":
                if (x + modele > 10 || (y<1 || y>10)) {
                    canAdd = false;
                }
                break;
            default:
                break;
        }

        for (int i = 0; i < flotte.size(); i++) {    // Parcours de la flotte
            Bateau bateau = flotte.get(i);
            int[] coordx = new int[5];
            int[] coordy = new int[5];

            for(int j=0; j<bateau.getModele(); j++){
                switch (bateau.getDirection()){
                    case "Haut" :
                        coordy[j] = y-j;
                        if (coordy[j] == y && bateau.getStartPosition()[0] == x){
                            canAdd = false;
                        }
                        break;
                    case "Bas" :
                        coordy[j] = y+j;
                        if (coordy[j] == y && bateau.getStartPosition()[0] == x){
                            canAdd = false;
                        }
                        break;
                    case "Gauche" :
                        coordx[j] = x-j;
                        if (coordx[j] == x && bateau.getStartPosition()[1] == y){
                            canAdd = false;
                        }
                        break;
                    case "Droite" :
                        coordx[j] = x+j;
                        if (coordx[j] == x && bateau.getStartPosition()[1] == y){
                            canAdd = false;
                        }
                        break;
                    default : break;
                }
            }
        }

        return canAdd;
    }
}
