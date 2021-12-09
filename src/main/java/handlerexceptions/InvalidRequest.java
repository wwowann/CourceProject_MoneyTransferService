package handlerexceptions;

public class InvalidRequest extends NullPointerException{
    public  InvalidRequest (String message){
        super (message);
       }
}
