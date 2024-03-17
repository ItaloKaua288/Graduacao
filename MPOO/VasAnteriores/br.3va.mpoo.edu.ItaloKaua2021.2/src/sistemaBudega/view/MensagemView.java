package sistemaBudega.view;

import javax.swing.JOptionPane;

public class MensagemView extends JOptionPane{
    public static void exibirMensagem(String msg) {
        showMessageDialog(null, msg, "Mensagem", INFORMATION_MESSAGE);
    }

    public static int encerrarSistema() {
        return showConfirmDialog(null, "Deseja encerrar a aplicação?", "", JOptionPane.OK_OPTION);
    }
}
