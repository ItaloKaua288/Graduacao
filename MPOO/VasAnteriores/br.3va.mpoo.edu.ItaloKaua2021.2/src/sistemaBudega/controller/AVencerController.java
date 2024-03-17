package sistemaBudega.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import sistemaBudega.model.BaseDados;
import sistemaBudega.model.Produto;
import sistemaBudega.view.AVencer;
import sistemaBudega.view.MensagemErroView;
import sistemaBudega.view.MensagemView;

public class AVencerController implements ActionListener {
    private AVencer aVencer;

    public AVencerController(AVencer aVencer) {
        this.aVencer = aVencer;
        controle();
    }

    private void controle() {
        aVencer.getBuscarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int prazo = Integer.parseInt(aVencer.getPrazoField().getText());
            ArrayList<Produto> produtosAVencer = BaseDados.buscarProdutoAVencer(prazo);
            if (produtosAVencer.size() > 0)
                MensagemView.exibirMensagem(produtosAVencer.toString());
            else
                MensagemView.exibirMensagem("Não existe(m) produto(s) a vencer em " + prazo + " dia(s)");
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
            MensagemErroView.exibirMensagemErro("Preencha o prazo em dias!");
        }
    }
    
}
