package tests;

import Exceptions.IllegalCoordinate;
import Exceptions.IllegalShipPlacement;
import Exceptions.NumberOfShipSizeExceeded;
import Modele.bateau.Boat;
import Modele.bateau.Fleet;
import Modele.coordonnes.Coordinate;
import Modele.coordonnes.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FleetTest {
    Coordinate a1 = new Coordinate(1,1);
    Coordinate a4= new Coordinate(1,4);
    Coordinate b9 = new Coordinate(2,9);
    Coordinate d5 = new Coordinate(4,5);
    Coordinate d2 = new Coordinate(4,2);

    Boat boat1;
    Boat boat2;
    Boat boat3;
    Boat boat4;
    Boat boat5;
    {
        try {
            boat1 = new Boat(a1,3, Direction.BOTTOM);
            boat2 = new Boat(a4,3, Direction.RIGHT);
            boat3 = new Boat(b9,4, Direction.UP);
            boat4 = new Boat(d5,2, Direction.LEFT);
            boat5 = new Boat(d2,3, Direction.RIGHT);
        } catch (IllegalCoordinate illegalCoordinate) {
            fail();
        }
    }

    Fleet createArmy = new Fleet();
    Fleet armyContainsBoat = new Fleet();

    @Test
    void createFleet(){
        try {
            createArmy.addBoat(boat1);
            createArmy.addBoat(boat2);
            createArmy.addBoat(boat3);
            createArmy.addBoat(boat4);
        } catch (IllegalShipPlacement | NumberOfShipSizeExceeded exception) {
            fail();
        }

        // L'exception est levée et stoppe le test
        assertThrows(NumberOfShipSizeExceeded.class , () -> {
            createArmy.addBoat(boat5);
        });
    }

    @Test
    void isContainsBoat(){
        try {
            armyContainsBoat.addBoat(boat1);
            armyContainsBoat.addBoat(boat2);
            armyContainsBoat.addBoat(boat3);
        } catch (IllegalShipPlacement | NumberOfShipSizeExceeded exception) {
            fail();
        }

        assertTrue(armyContainsBoat.isContainsBoat(boat1));
        assertTrue(armyContainsBoat.isContainsBoat(boat2));
        assertTrue(armyContainsBoat.isContainsBoat(boat3));
        assertFalse(armyContainsBoat.isContainsBoat(boat4));
        assertFalse(armyContainsBoat.isContainsBoat(boat5));
    }
}