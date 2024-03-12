package model;

public class ClienteException extends Exception{
    public ClienteException() {
        super("Cliente não faz parte da base");
    }
}
