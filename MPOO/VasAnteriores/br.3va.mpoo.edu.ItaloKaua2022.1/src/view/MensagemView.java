package view;

import javax.swing.JOptionPane;

public class MensagemView extends JOptionPane{
    public static void exibirMensagem(String msg) {
        showMessageDialog(null, msg, "Mensagem", JOptionPane.CLOSED_OPTION);
    }

    public static void exibirMensagemErro(String msg) {
        showMessageDialog(null, msg, "Mensagem", JOptionPane.ERROR_MESSAGE);
    }

    public static void exibirErroNimbus() {
        showMessageDialog(null, "Erro aparência Nimbus: O sistema será encerrado!", "Erro Nimbus", JOptionPane.ERROR_MESSAGE);
    }
}
