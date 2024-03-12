package view;

import javax.swing.JOptionPane;

public class MensagemView extends JOptionPane{
	public static void exibirMensagem(String mensagem) {
		showMessageDialog(null, mensagem, "mensagem", -1); //RAD: erro personaliza��o
	}
	
	public static int exibirMensagemEncerrarSistema() {
		return showConfirmDialog(null, "Deseja realmente sair?", "MPOOAmigodoPet", 1);
	}
}
