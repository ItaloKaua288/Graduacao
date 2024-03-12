package model;

public class CPFException extends Exception {
    public CPFException() {
        super("CPF informado é inválido");
    }
}
