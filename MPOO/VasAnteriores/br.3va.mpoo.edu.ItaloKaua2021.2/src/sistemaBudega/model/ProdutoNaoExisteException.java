package sistemaBudega.model;

import sistemaBudega.view.MensagemErroView;

public class ProdutoNaoExisteException extends Exception{
    public ProdutoNaoExisteException() {
        MensagemErroView.exibirMensagemErro("Produto não localizado!");
    }
}
