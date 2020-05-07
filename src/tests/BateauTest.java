package tests;

import Exceptions.IllegalCoordinate;
import Modele.bateau.Bateau;
import Modele.coordonnes.Coordonnes;
import Modele.coordonnes.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BateauTest {
    @Test
    void createBoat(){
        Coordonnes a1 = new Coordonnes(1,1);
        Coordonnes a2 = new Coordonnes(1,2);
        Coordonnes a3 = new Coordonnes(1,3);
        Coordonnes a4 = new Coordonnes(1,4);


        try {
            Bateau b1 = new Bateau(a2, 3, Direction.DROITE);
            Bateau b2 = new Bateau(a1, 5, Direction.DROITE);
            Bateau b3 = new Bateau(a3, 4, Direction.DROITE);
        } catch (IllegalCoordinate illegalCoordinate){
            fail();
        }

        try {
            Bateau b4 = new Bateau(a4, 3, Direction.HAUT);
        }catch (IllegalCoordinate illegalCoordinate){
            fail();
        }
    }
}