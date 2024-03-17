package sistemaBudega.view;

import javax.swing.JOptionPane;

public class MensagemErroView extends JOptionPane{
    public static void exibirMensagemErro(String msg) {
        showMessageDialog(null, msg, "Erro", ERROR_MESSAGE);
    }
}
