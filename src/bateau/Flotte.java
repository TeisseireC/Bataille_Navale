package bateau;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private List<Bateau> flotte = new ArrayList<>();

    public String addBoat(Bateau bateau) {
        String result;

        if (verifyModel(bateau.getModel())) {
            if (verifyCoord(bateau)) {
                flotte.add(bateau);
                result = "Bateau ajouté";
            } else {
                result = "La position du bateau est incorrecte";
            }
        } else {
            result = "Bateau de longueur " + bateau.getModel() + " déjà existant";
        }

        return result;
    }

    /**
     * @param model verify boat
     * @return
     */
    public boolean verifyModel(int model) {
        boolean canAdd = true;

        if (flotte.size() < 5) {
            int tampModelCount = 0;
            for (Bateau bateau : flotte) {
                if (model == 2) {
                    if (bateau.getModel() == 2) {
                        tampModelCount++;
                    }
                    if (tampModelCount >= 2) {
                        canAdd = false;
                    }
                } else {
                    if (bateau.getModel() == model) {
                        canAdd = false;
                    }
                }
            }
        } else {
            canAdd = false;
        }

        return canAdd;
    }

    /**
     * @param newBoat
     * @return
     */
    public boolean verifyCoord(Bateau newBoat) {
        boolean canAdd = true;

        switch (newBoat.getDirection()) {
            case "Haut":
                if (newBoat.getStartPosition()[1] - newBoat.getModel() < 1 || (newBoat.getStartPosition()[0] < 1 || newBoat.getStartPosition()[0] > 10)) {
                    canAdd = false;
                }
                break;
            case "Bas":
                if (newBoat.getStartPosition()[1] + newBoat.getModel() > 10 || (newBoat.getStartPosition()[0] < 1 || newBoat.getStartPosition()[0] > 10)) {
                    canAdd = false;
                }
                break;
            case "Gauche":
                if (newBoat.getStartPosition()[0] - newBoat.getModel() < 1 || (newBoat.getStartPosition()[0] < 1 || newBoat.getStartPosition()[0] > 10)) {
                    canAdd = false;
                }
                break;
            case "Droite":
                if (newBoat.getStartPosition()[0] + newBoat.getModel() > 10 || (newBoat.getStartPosition()[0] < 1 || newBoat.getStartPosition()[0] > 10)) {
                    canAdd = false;
                }
                break;
            default:
                break;
        }

        // OldBoats
        for (Bateau oldBoat : flotte) {
            int[] coordxOldBoat = new int[5];
            int[] coordyOldBoat = new int[5];

            int[] coordxNewBoat = new int[5];
            int[] coordyNewBoat = new int[5];

            for (int j = 0; j < newBoat.getModel(); j++) {
                switch (newBoat.getDirection()) {
                    case "Haut":
                        coordyNewBoat[j] = newBoat.getStartPosition()[1] - j;
                        break;
                    case "Bas":
                        coordyNewBoat[j] = newBoat.getStartPosition()[1] + j;
                        break;
                    case "Gauche":
                        coordxNewBoat[j] = newBoat.getStartPosition()[0] - j;
                        break;
                    case "Droite":
                        coordxNewBoat[j] = newBoat.getStartPosition()[0] + j;
                        break;
                    default:
                        break;
                }
            }
            for (int j = 0; j < oldBoat.getModel(); j++) {
                switch (oldBoat.getDirection()) {
                    case "Haut":
                        coordyOldBoat[j] = oldBoat.getStartPosition()[1] - j;
                        for (int k = 0; k < newBoat.getModel(); k++) {
                            if (coordyOldBoat[j] == coordyNewBoat[k] && oldBoat.getStartPosition()[0] == newBoat.getStartPosition()[0]) {
                                canAdd = false;
                            }
                        }
                        break;
                    case "Bas":
                        coordyOldBoat[j] = oldBoat.getStartPosition()[1] + j;
                        for (int k = 0; k < newBoat.getModel(); k++) {
                            if (coordyOldBoat[j] == coordyNewBoat[k] && oldBoat.getStartPosition()[0] == newBoat.getStartPosition()[0]) {
                                canAdd = false;
                            }
                        }
                        break;
                    case "Gauche":
                        coordxOldBoat[j] = oldBoat.getStartPosition()[0] - j;
                        for (int k = 0; k < newBoat.getModel(); k++) {
                            if (coordxOldBoat[j] == coordxNewBoat[k] && oldBoat.getStartPosition()[1] == newBoat.getStartPosition()[1]) {
                                canAdd = false;
                            }
                        }
                        break;
                    case "Droite":
                        coordxOldBoat[j] = oldBoat.getStartPosition()[0] + j;
                        for (int k = 0; k < newBoat.getModel(); k++) {
                            if (coordxOldBoat[j] == coordxNewBoat[k] && oldBoat.getStartPosition()[1] == newBoat.getStartPosition()[1]) {
                                canAdd = false;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        return canAdd;
    }
}
