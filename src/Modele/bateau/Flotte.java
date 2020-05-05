package Modele.bateau;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private List<Bateau> flotte = new ArrayList<>();

    public boolean addBoat(Bateau bateau) {
        if (isFlotteCanAddBoat(bateau)){
            return this.flotte.add(bateau);
        }else{
            return false;
        }
    }

    private boolean isFlotteCanAddBoat(Bateau bateau){
        boolean result = true;
        int countBoatLenght3 = 0;

        if (this.flotte.size() < 5 && this.flotte.size() > 0){
            for (int i=0; i<this.flotte.size(); i++){
                if (bateau.getTaille() == 3){
                    if (this.flotte.get(i).getTaille() == 3){
                        countBoatLenght3++;
                        if (countBoatLenght3 >=2){
                            result = false;
                        }
                    }
                }else{
                    if (this.flotte.get(i).getTaille() == bateau.getTaille()){
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
