package model;

import view.MensagemView;

public class CPFException extends RuntimeException{
    public CPFException() {
        super(ValidadorCPF.CPF_INVALIDO);
        MensagemView.exibirMensagem(ValidadorCPF.CPF_INVALIDO);
    }
}
