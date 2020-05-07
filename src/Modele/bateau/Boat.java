package Modele.bateau;

import Exceptions.IllegalCoordinate;
import Modele.coordonnes.Coordinate;
import Modele.coordonnes.Direction;

import java.util.ArrayList;
import java.util.List;

public class Boat {

    private List<Coordinate> coordinateList = new ArrayList<>();
    private int boatSize;

    public Boat(Coordinate startPosition, int boatSize, Direction direction) throws IllegalCoordinate {
        this.coordinateList.add(startPosition);
        this.boatSize = boatSize;

        try {
            setAllCoordinates(direction);
        } catch (IllegalCoordinate illegalCoordinate) {
            throw new IllegalCoordinate();
        }
    }

    private void setAllCoordinates(Direction direction) throws IllegalCoordinate {
        int startAbscisse = this.coordinateList.get(0).getAbscissa();
        int startOrdonnee = this.coordinateList.get(0).getOrdinate();

        for (int i = 1; i<this.boatSize; i++){
            switch (direction){
                case UP:
                    if (startOrdonnee - i < 1){
                        throw new IllegalCoordinate();
                    }
                    this.coordinateList.add(new Coordinate(startAbscisse , startOrdonnee - i));
                    break;
                case BOTTOM:
                    if (startOrdonnee + i > 10){
                        throw new IllegalCoordinate();
                    }
                    this.coordinateList.add(new Coordinate(startAbscisse , startOrdonnee + i));
                    break;
                case LEFT:
                    if (startAbscisse - i < 1){
                        throw new IllegalCoordinate();
                    }
                    this.coordinateList.add(new Coordinate(startAbscisse - i , startOrdonnee));
                    break;
                case RIGHT:
                    if (startAbscisse + i > 10){
                        throw new IllegalCoordinate();
                    }
                    this.coordinateList.add(new Coordinate(startAbscisse + i , startOrdonnee));
                    break;
            }
        }
    }

    public int getBoatSize(){
        return this.boatSize;
    }

    public boolean isCrossOverBoat(Boat newBoat){
        boolean result = true;

        for (int i = 0; i<newBoat.coordinateList.size(); i++) {
            if (Coordinate.isCoordonneValid(newBoat.coordinateList.get(i))) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object boat) {
        if ((boat instanceof Boat) && (((Boat) boat).boatSize == (this.boatSize) && ((Boat) boat).coordinateList == (this.coordinateList))) {
            return true;
        } else {
            return false;
        }
    }
}
