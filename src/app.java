import bateau.Bateau;
import bateau.Flotte;

public class app {
    public static void main(String[] args) {
        Flotte flotte = new Flotte();
        String message ="";

        Bateau bateauDeux1 = new Bateau(1,1,2, "Bas");
        Bateau bateauDeux2 = new Bateau(4,4,2, "Droite");
        Bateau bateauDeux3 = new Bateau(7,7,2, "Bas");

        System.out.println(flotte.addBateau(bateauDeux1));
        System.out.println(flotte.addBateau(bateauDeux2));
        System.out.println(flotte.addBateau(bateauDeux3));

    }
}
