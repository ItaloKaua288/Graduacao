package view;

import javax.swing.JOptionPane;

public class MensagemView extends JOptionPane{
    public void exibirMensagem(String msg) {
        showMessageDialog(null, msg, "Mensagem", JOptionPane.CLOSED_OPTION);
    }

    public void exibirMensagemErro(String msg) {
        showMessageDialog(null, msg, "Mensagem", JOptionPane.ERROR_MESSAGE);
    }

}
