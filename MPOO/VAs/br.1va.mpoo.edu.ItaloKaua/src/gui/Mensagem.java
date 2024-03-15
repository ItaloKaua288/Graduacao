package gui;

import javax.swing.JOptionPane;

public class Mensagem {
    public static final String PRODUTO_SUCESSO = "Produto cadastrado com sucesso!";
    public static final String PRODUTO_ERRO = "Erro ao cadastrar produto";

    public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Mensagem", 1);
    }
}
