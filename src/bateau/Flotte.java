package bateau;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private List<Bateau> flotte = new ArrayList<>();

    public String addBateau(int x, int y, int modele, String direction){
        String resultat = "";

        if (flotte.size() < 5){ // Si la flotte n'est pas pleine
            boolean canAdd = true; // Variable pour voir si on peux ajouter
            int tmpModeleCount = 0; // Variable qui compte le nombre de bateaux de longueur 2
            for (int i=0; i<flotte.size(); i++){    // Parcours de la flotte
                if (modele == 2){   // Si on veux ajouter un bateau de longueur 2
                    if (flotte.get(i).getModele() == 2){   // On compte le nombre de bateaux de longueur 2 déjà présent
                        tmpModeleCount++;
                    }
                    if (tmpModeleCount == 2){ // Si il y en a déjà 2 alors on ne peux pas rajouter
                        canAdd = false;
                        resultat = "Il existe déjà 2 bateaux de longueur 2";
                    }
                }else{  // Si on veux ajouter un bateau d'une autre longueur
                    if (flotte.get(i).getModele() == modele){   // Vérification que le bateau de cette longueur n'existe pas
                        canAdd = false;
                        resultat = "Il existe déjà un bateau de longueur "+modele;
                    }
                }
            }
            if (canAdd){    // Si toutes les vérifications sont bonnes alors on ajoute
                flotte.add(new Bateau(x,y,modele,direction));
                resultat = "Le bateau a bien été ajouté";
            }
        }
        return resultat;
    }
}
