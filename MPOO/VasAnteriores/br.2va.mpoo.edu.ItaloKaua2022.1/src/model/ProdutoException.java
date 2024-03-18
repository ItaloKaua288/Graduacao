package model;

import view.TelaMensagem;

public class ProdutoException extends Exception{
    public ProdutoException() {
        TelaMensagem.exibirMensagem("Produto já cadastrado!");
    }
}
