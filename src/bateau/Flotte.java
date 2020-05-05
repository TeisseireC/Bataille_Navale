package bateau;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private List<Bateau> flotte = new ArrayList<>();

    public boolean addBoat(Bateau bateau) {
        return flotte.add(bateau);
    }

    public boolean isContainsBoat(Bateau bateau){
        return this.flotte.contains(bateau);
    }
}
