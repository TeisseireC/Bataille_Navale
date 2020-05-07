package Modele.bateau;

import Exceptions.IllegalShipPlacement;
import Exceptions.NumberOfShipSizeExceeded;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Boat> boatList = new ArrayList<>();

    public void addBoat(Boat newBoat) throws IllegalShipPlacement, NumberOfShipSizeExceeded {
        if (!isFleetCanAddBoat(newBoat)) {
            throw new NumberOfShipSizeExceeded("This size is already in our army");
        }
        for (Boat ourBoat : this.boatList){
            if (newBoat.isCrossOverBoat(ourBoat)){
                throw new IllegalShipPlacement();
            }
        }

        this.boatList.add(newBoat);
    }

    private boolean isFleetCanAddBoat(Boat boat){
        boolean result = true;
        int countBoatLenght3 = 0;

        if (this.boatList.size() < 5 && this.boatList.size() > 0){
            for(Boat ourBoat : this.boatList){
                if (boat.getBoatSize() == 3){
                    if (ourBoat.getBoatSize() == 3){
                        countBoatLenght3++;
                        if (countBoatLenght3 >=2){
                            result = false;
                        }
                    }
                }else{
                    if (ourBoat.getBoatSize() == boat.getBoatSize()){
                        result = false;
                    }
                }
            }
        }else if(this.boatList.size() >= 5){
            result = false;
        }

        return result;
    }

    public boolean isContainsBoat(Boat boat){
        return this.boatList.contains(boat);
    }
}
