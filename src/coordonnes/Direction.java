package coordonnes;

import bateau.Bateau;

public enum Direction {
    //Objets directement construits
    DROITE ("Droite","x"),
    GAUCHE ("Gauche","x"),
    HAUT ("Haut","y"),
    BAS ("Bas","y");

    private String direction = "";
    private String axe = "";

    //Constructeur
    Direction(String direction,String axe){
        this.direction = direction;
        this.axe = axe;
    }

    public String getAxe(){
        return axe;
    }

    public String getDirection(){
        return direction;
    }

    public String getValue(Bateau bateau){
        return Direction.valueOf(bateau.getDirection()).getAxe();
    }
}
