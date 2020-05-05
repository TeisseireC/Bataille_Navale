package tests;

import Controlleur.Controlleur;
import Modele.bateau.Bateau;
import Modele.coordonnes.Coordonnes;
import Modele.coordonnes.Direction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlleurTest {
    Coordonnes a1 = new Coordonnes(1,1);
    Coordonnes j4= new Coordonnes(10,4);
    Coordonnes a10 = new Coordonnes(1,10);
    Coordonnes j10 = new Coordonnes(10,10);
    Coordonnes a4= new Coordonnes(1,4);
    Coordonnes a5= new Coordonnes(1,5);
    Coordonnes b9 = new Coordonnes(2,9);
    Coordonnes d5 = new Coordonnes(4,5);
    Coordonnes d2 = new Coordonnes(4,2);
    Coordonnes coordShouldBeFalseA0 = new Coordonnes(1,0);
    Coordonnes coordShouldBeFalse25 = new Coordonnes(-2,5);
    Coordonnes coordShouldBeFalse113 = new Coordonnes(1,13);

    Bateau boat1 = new Bateau(a1,3, Direction.BAS);
    Bateau boat2 = new Bateau(a4,3, Direction.DROITE);
    Bateau boat3 = new Bateau(b9,4, Direction.HAUT);
    Bateau boat4 = new Bateau(d5,2, Direction.GAUCHE);
    Bateau boat5 = new Bateau(d2,5, Direction.DROITE);
    Bateau boatCantBePlace1 = new Bateau(a5,3, Direction.DROITE);
    Bateau boatCantBePlace2 = new Bateau(a5,5, Direction.HAUT);


    Controlleur controlleur = new Controlleur();
    @Test
    void isStartCoordonneValid() {
        assertTrue(controlleur.isStartCoordonneValid(a1));
        assertTrue(controlleur.isStartCoordonneValid(j4));
        assertTrue(controlleur.isStartCoordonneValid(a10));
        assertTrue(controlleur.isStartCoordonneValid(j10));
        assertFalse(controlleur.isStartCoordonneValid(coordShouldBeFalseA0));
        assertFalse(controlleur.isStartCoordonneValid(coordShouldBeFalse25));
        assertFalse(controlleur.isStartCoordonneValid(coordShouldBeFalse113));
    }

    @Test
    void isBoatCanBePlace() {
        List<Bateau> bateauxList = new ArrayList<>();

        assertTrue(controlleur.isBoatCanBePlace(bateauxList,boat1));
        bateauxList.add(boat1);
        assertTrue(controlleur.isBoatCanBePlace(bateauxList,boat2));
        bateauxList.add(boat2);
        assertTrue(controlleur.isBoatCanBePlace(bateauxList,boat3));
        bateauxList.add(boat3);
        assertTrue(controlleur.isBoatCanBePlace(bateauxList,boat4));
        bateauxList.add(boat4);
        assertTrue(controlleur.isBoatCanBePlace(bateauxList,boat5));
        bateauxList.add(boat5);
        assertFalse(controlleur.isBoatCanBePlace(bateauxList,boatCantBePlace1));
        assertFalse(controlleur.isBoatCanBePlace(bateauxList,boatCantBePlace2));
    }
}