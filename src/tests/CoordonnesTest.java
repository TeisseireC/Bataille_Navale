package tests;

import Modele.coordonnes.Coordonnes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordonnesTest {

    Coordonnes c5 = new Coordonnes(3,5);

    @Test
    void getAbscisse() {
        assertTrue(c5.getAbscisse() == 3);
        assertFalse(c5.getAbscisse() == 4);
    }

    @Test
    void getOrdonnee() {
        assertTrue(c5.getOrdonnee() == 5);
        assertFalse(c5.getOrdonnee() == 4);
    }
}