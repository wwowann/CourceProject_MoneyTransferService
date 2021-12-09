package cource_project_money_transfer_service.demo.handlerexceptions;

public class InvalidRequest extends NullPointerException{
    public  InvalidRequest (String message){
        super (message);
       }
}
