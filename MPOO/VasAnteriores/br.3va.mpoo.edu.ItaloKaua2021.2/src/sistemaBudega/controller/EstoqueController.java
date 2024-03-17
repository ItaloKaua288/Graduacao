package sistemaBudega.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import sistemaBudega.view.AVencer;
import sistemaBudega.view.DescontoView;
import sistemaBudega.view.EstoqueView;
import sistemaBudega.view.MensagemView;

public class EstoqueController {
    private EstoqueView estoqueView;
    private DescontoView descontoView;
    private AVencer aVencer;
    private ButtonHandler buttonHandler;
    private KeyHandler keyHandler;

    public EstoqueController(EstoqueView estoqueView, DescontoView descontoView, AVencer aVencer) {
        this.estoqueView = estoqueView;
        this.descontoView = descontoView;
        this.aVencer = aVencer;
        this.buttonHandler = new ButtonHandler();
        this.keyHandler = new KeyHandler();

        controle();
    }

    private void controle() {
        estoqueView.getVerProdutosButton().addActionListener(buttonHandler);
        estoqueView.getPromocaButton().addActionListener(buttonHandler);
        estoqueView.getSairButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (MensagemView.encerrarSistema() == 0)
                    System.exit(0);
            }
            
        });

        estoqueView.getVerProdutosButton().addKeyListener(keyHandler);
        estoqueView.getPromocaButton().addKeyListener(keyHandler);
        estoqueView.getSairButton().addKeyListener(keyHandler);
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                if (MensagemView.encerrarSistema() == 0)
                    System.exit(0);
            super.keyPressed(e);
        }
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == estoqueView.getVerProdutosButton())
                aVencer.setVisible(true);

            if (e.getSource() == estoqueView.getPromocaButton())
                descontoView.setVisible(true);
        }
        
    }
}
