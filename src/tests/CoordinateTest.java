package tests;

import Modele.coordonnes.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    Coordinate c5 = new Coordinate(3,5);

    @Test
    void getAbscissa() {
        assertTrue(c5.getAbscissa() == 3);
        assertFalse(c5.getAbscissa() == 4);
    }

    @Test
    void getOrdinate() {
        assertTrue(c5.getOrdinate() == 5);
        assertFalse(c5.getOrdinate() == 4);
    }
}