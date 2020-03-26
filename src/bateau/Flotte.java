package bateau;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private List<Bateau> flotte = new ArrayList<>();

    public String addBoat(Bateau bateau) {
        String result;

        if (verifyModel(bateau.getModel())) {
            if (verifyCoord(bateau.getStartPosition()[0], bateau.getStartPosition()[1], bateau.getModel(), bateau.getDirection())) {
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
     * @param x
     * @param y
     * @param model
     * @param direction
     * @return
     */
    public boolean verifyCoord(int x, int y, int model, String direction) {
        boolean canAdd = true;

        switch (direction) {
            case "Haut":
                if (y - model < 1 || (x < 1 || x > 10)) {
                    canAdd = false;
                }
                break;
            case "Bas":
                if (y + model > 10 || (x < 1 || x > 10)) {
                    canAdd = false;
                }
                break;
            case "Gauche":
                if (x - model < 1 || (y < 1 || y > 10)) {
                    canAdd = false;
                }
                break;
            case "Droite":
                if (x + model > 10 || (y < 1 || y > 10)) {
                    canAdd = false;
                }
                break;
            default:
                break;
        }

        // OldBoats
        for (Bateau bateau : flotte) {
            int[] coordxOldBoat = new int[5];
            int[] coordyOldBoat = new int[5];

            int[] coordxNewBoat = new int[5];
            int[] coordyNewBoat = new int[5];

            for (int j = 0; j < model; j++) {
                switch (direction) {
                    case "Haut":
                        coordyNewBoat[j] = y - j;
                        break;
                    case "Bas":
                        coordyNewBoat[j] = y + j;
                        break;
                    case "Gauche":
                        coordxNewBoat[j] = x - j;
                        break;
                    case "Droite":
                        coordxNewBoat[j] = x + j;
                        break;
                    default:
                        break;
                }
            }
            for (int j = 0; j < bateau.getModel(); j++) {
                switch (bateau.getDirection()) {
                    case "Haut":
                        coordyOldBoat[j] = bateau.getStartPosition()[1] - j;
                        for (int k = 0; k < model; k++) {
                            if (coordyOldBoat[j] == coordyNewBoat[k] && bateau.getStartPosition()[0] == x) {
                                canAdd = false;
                            }
                        }
                        break;
                    case "Bas":
                        coordyOldBoat[j] = bateau.getStartPosition()[1] + j;
                        for (int k = 0; k < model; k++) {
                            if (coordyOldBoat[j] == coordyNewBoat[k] && bateau.getStartPosition()[0] == x) {
                                canAdd = false;
                            }
                        }
                        break;
                    case "Gauche":
                        coordxOldBoat[j] = bateau.getStartPosition()[0] - j;
                        for (int k = 0; k < model; k++) {
                            if (coordxOldBoat[j] == coordxNewBoat[k] && bateau.getStartPosition()[1] == y) {
                                canAdd = false;
                            }
                        }
                        break;
                    case "Droite":
                        coordxOldBoat[j] = bateau.getStartPosition()[0] + j;
                        for (int k = 0; k < model; k++) {
                            if (coordxOldBoat[j] == coordxNewBoat[k] && bateau.getStartPosition()[1] == y) {
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
