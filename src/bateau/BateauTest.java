package bateau;

import coordonnes.Coordonnes;
import coordonnes.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BateauTest {
    @Test
    void createBoat(){
        Coordonnes a2 = new Coordonnes(1,2);
        Bateau b1 = new Bateau(a2, 3, Direction.BAS);

        assertTrue(b1.isOnCoordinate(a2));

        Coordonnes a1 = new Coordonnes(1,1);
        Coordonnes a3 = new Coordonnes(1,3);
        Coordonnes a4 = new Coordonnes(1,4);

        assertFalse(b1.isOnCoordinate(a1));

        assertTrue(b1.isOnCoordinate(a3));
        assertTrue(b1.isOnCoordinate(a4));
    }
}