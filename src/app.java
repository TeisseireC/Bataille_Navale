import bateau.Bateau;
import bateau.Flotte;

public class app {
    public static void main(String[] args) {
        Flotte flotte = new Flotte();
        String message ="";

        Bateau bateauDeux1 = new Bateau(1,1,2, "Bas");
        Bateau bateauDeux2 = new Bateau(2,2,2, "Droite");
        Bateau bateauTrois1 = new Bateau(2, 1, 3, "Droite");
        Bateau bateauQuatre = new Bateau(7, 1, 4, "Gauche");
        System.out.println(flotte.addBoat(bateauDeux1));
        System.out.println(flotte.addBoat(bateauDeux2));
        System.out.println(flotte.addBoat(bateauTrois1));
        System.out.println(flotte.addBoat(bateauQuatre));

    }
}
