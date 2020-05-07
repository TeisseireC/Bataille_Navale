package Exceptions;

public class NumberOfShipSizeExceeded extends Exception{
    public NumberOfShipSizeExceeded(){
        super();
    }
    public NumberOfShipSizeExceeded(String message){
        super(message);
    }
}
