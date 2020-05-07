package Modele.bateau;

import Exceptions.IllegalShipPlacement;
import Exceptions.NumberOfShipSizeExceeded;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private List<Bateau> flotte = new ArrayList<>();

    public void addBoat(Bateau newBoat) throws IllegalShipPlacement, NumberOfShipSizeExceeded {
        if (!isFlotteCanAddBoat(newBoat)) {
            throw new NumberOfShipSizeExceeded("This size is already in our army");
        }
        for (Bateau ourBoat : this.flotte){
            if (newBoat.isCrossOverBoat(ourBoat)){
                throw new IllegalShipPlacement();
            }
        }

        this.flotte.add(newBoat);
    }

    private boolean isFlotteCanAddBoat(Bateau bateau){
        boolean result = true;
        int countBoatLenght3 = 0;

        if (this.flotte.size() < 5 && this.flotte.size() > 0){
            for(Bateau ourBoat : this.flotte){
                if (bateau.getTaille() == 3){
                    if (ourBoat.getTaille() == 3){
                        countBoatLenght3++;
                        if (countBoatLenght3 >=2){
                            result = false;
                        }
                    }
                }else{
                    if (ourBoat.getTaille() == bateau.getTaille()){
                        result = false;
                    }
                }
            }
        }else if(this.flotte.size() >= 5){
            result = false;
        }

        return result;
    }

    public boolean isContainsBoat(Bateau bateau){
        return this.flotte.contains(bateau);
    }
}
