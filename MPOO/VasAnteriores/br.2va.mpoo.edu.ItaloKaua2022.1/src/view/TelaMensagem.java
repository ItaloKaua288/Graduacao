package view;

import javax.swing.JOptionPane;

public class TelaMensagem extends JOptionPane{
    public static void exibirErroNimbus() {
        showMessageDialog(null, "Erro aparência Nimbus: O sistema será incerrado!", "Error Nimbus", ERROR_MESSAGE);
    }

    public static void exibirMensagem(String msg) {
        showMessageDialog(null, msg, "Mensagem", INFORMATION_MESSAGE);
    }
}
