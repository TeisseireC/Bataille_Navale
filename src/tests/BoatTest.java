package tests;

import Exceptions.IllegalCoordinate;
import Modele.bateau.Boat;
import Modele.coordonnes.Coordinate;
import Modele.coordonnes.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatTest {
    @Test
    void createBoat(){
        Coordinate a1 = new Coordinate(1,1);
        Coordinate a2 = new Coordinate(1,2);
        Coordinate a3 = new Coordinate(1,3);
        Coordinate a4 = new Coordinate(1,4);


        try {
            Boat b1 = new Boat(a2, 3, Direction.RIGHT);
            Boat b2 = new Boat(a1, 5, Direction.RIGHT);
            Boat b3 = new Boat(a3, 4, Direction.RIGHT);
        } catch (IllegalCoordinate illegalCoordinate){
            fail();
        }

        try {
            Boat b4 = new Boat(a4, 3, Direction.UP);
        }catch (IllegalCoordinate illegalCoordinate){
            fail();
        }
    }
}