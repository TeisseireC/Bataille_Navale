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

    public boolean verifyModele(int modele){ // Vérifie si la taille du bateau existe déja ou pas
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

        switch (direction) {    // Switch qui vérifie si on ne dépasse pas de la map
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
            Bateau bateau = flotte.get(i);  // OldBoats
            int[] coordxOldBoat = new int[5];
            int[] coordyOldBoat = new int[5];

            int[] coordxNewBoat = new int[5];
            int[] coordyNewBoat = new int[5];

            for(int j=0; j<modele; j++) {   // Boucle qui définie tout les points du nouveau bateau
                switch (direction) {
                    case "Haut":
                        coordyNewBoat[j] = y - j;
                        break;
                    case "Bas":
                        coordyNewBoat[j] = y + j;
                        break;
                    case "Gauche":
                        coordxNewBoat[j] = x- j;
                        break;
                    case "Droite":
                        coordxNewBoat[j] = x+ j;
                        break;
                    default:
                        break;
                }
            }
            for(int j=0; j<bateau.getModele(); j++){    // Boucle qui vérifie si les points du nouveau bateau ne sont pas en confli avec ceux des anciens
                switch (bateau.getDirection()){
                    case "Haut" :
                        coordyOldBoat[j] = bateau.getStartPosition()[1]-j;  // Calcul position Old boat
                        for (int k=0; k<modele; k++){   // Boucle de vérification de la position de l'old boat contre celles du new boat
                            if (coordyOldBoat[j] == coordyNewBoat[k] && bateau.getStartPosition()[0] == x){
                                canAdd = false;
                            }
                        }
                        break;
                    case "Bas" :
                        coordyOldBoat[j] = bateau.getStartPosition()[1]+j;  // Same here, juste le calcul qui change
                        for (int k=0; k<modele; k++){
                            if (coordyOldBoat[j] == coordyNewBoat[k] && bateau.getStartPosition()[0] == x){
                                canAdd = false;
                            }
                        }
                        break;
                    case "Gauche" :
                        coordxOldBoat[j] = bateau.getStartPosition()[0]-j;
                        for (int k=0; k<modele; k++){
                            if (coordxOldBoat[j] == coordxNewBoat[k] && bateau.getStartPosition()[1] == y){
                                canAdd = false;
                            }
                        }
                        break;
                    case "Droite" :
                        coordxOldBoat[j] = bateau.getStartPosition()[0]+j;
                        for (int k=0; k<modele; k++){
                            if (coordxOldBoat[j] == coordxNewBoat[k] && bateau.getStartPosition()[1] == y){
                                canAdd = false;
                            }
                        }
                        break;
                    default : break;
                }
            }
        }

        return canAdd;
    }
}
