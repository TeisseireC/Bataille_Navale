package coordonnes;

public class Coordonnes {

    private int x;
    private int y;

    public Coordonnes(int x,int y){
        if(coordoneesBetween1and10(x,y)){
            this.setX(x);
            this.setY(y);
        }else{
            System.out.println("les coordonnées ne sont pas correct");
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean coordoneesBetween1and10(int x,int y){
        if(x<1 || x>10 || y<1 || y>10){
            return false;
        }else{
            return true;
        }
    }
}
