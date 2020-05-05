package tests;

import Modele.bateau.Bateau;
import Modele.bateau.Flotte;
import Modele.coordonnes.Coordonnes;
import Modele.coordonnes.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlotteTest {
    Coordonnes a1 = new Coordonnes(1,1);
    Coordonnes a4= new Coordonnes(1,4);
    Coordonnes b9 = new Coordonnes(2,9);
    Coordonnes d5 = new Coordonnes(4,5);
    Coordonnes d2 = new Coordonnes(4,2);

    Bateau boat1 = new Bateau(a1,3, Direction.BAS);
    Bateau boat2 = new Bateau(a4,3, Direction.DROITE);
    Bateau boat3 = new Bateau(b9,4, Direction.HAUT);
    Bateau boat4 = new Bateau(d5,2, Direction.GAUCHE);
    Bateau boat5 = new Bateau(d2,3, Direction.DROITE);

    Flotte createArmy = new Flotte();
    Flotte armyContainsBoat = new Flotte();
    @Test
    void createFlotte(){
        assertTrue(createArmy.addBoat(boat1));
        assertTrue(createArmy.addBoat(boat2));
        assertTrue(createArmy.addBoat(boat3));
        assertFalse(createArmy.addBoat(boat5));
    }

    @Test
    void isContainsBoat(){
        armyContainsBoat.addBoat(boat1);
        armyContainsBoat.addBoat(boat2);
        armyContainsBoat.addBoat(boat3);

        assertTrue(armyContainsBoat.isContainsBoat(boat1));
        assertTrue(armyContainsBoat.isContainsBoat(boat2));
        assertTrue(armyContainsBoat.isContainsBoat(boat3));
        assertFalse(armyContainsBoat.isContainsBoat(boat4));
        assertFalse(armyContainsBoat.isContainsBoat(boat5));
    }
}