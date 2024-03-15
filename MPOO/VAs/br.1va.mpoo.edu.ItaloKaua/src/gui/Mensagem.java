package gui;

import javax.swing.JOptionPane;

public class Mensagem {
    public static final String PRODUTO_SUCESSO = "Produto cadastrado com sucesso!";
    public static final String PRODUTO_ERRO = "Erro ao cadastrar produto";

    public static final String DESCONTO_SUPERIOR = "Desconto não permitido: superior ao permitido!";
    public static final String DESCONTO_VALOR_MINIMO = "Desconto não permitido: Compra não atingiu o valor mínimo!";

    public static final String PRODUTO_INSUFICIENTE = "Produto insuficiente!";

    public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Mensagem", 1);
    }
}
