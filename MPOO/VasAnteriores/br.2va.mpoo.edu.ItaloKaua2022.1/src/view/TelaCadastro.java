package view;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastro extends Tela{
    private JLabel codBarrasLabel, validadeLabel, fornecedorLabel, obrigatorioLabel;
    private JTextField codBarrasField, fornecedorField;
    private JFormattedTextField validadeField;
    private JButton addButton;

    public TelaCadastro() {
        super("Cadastro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(140, 260);

        codBarrasLabel = new JLabel("Código de Barras");
        codBarrasField = new JTextField(10);
        validadeLabel = new JLabel("Validade");
        validadeField = new JFormattedTextField(new SimpleDateFormat("dd.MM.yyyy"));
        validadeField.setValue(new Date());
        fornecedorLabel = new JLabel("Fornecedor");
        fornecedorField = new JTextField(10);
        obrigatorioLabel = new JLabel("todos os campos são obrigatorios");
        obrigatorioLabel.setFont(new Font("", Font.BOLD, 7));
        addButton = new JButton("Add");

        add(codBarrasLabel);
        add(codBarrasField);
        add(validadeLabel);
        add(validadeField);
        add(fornecedorLabel);
        add(fornecedorField);
        add(obrigatorioLabel);
        add(addButton);
    }

    public JTextField getCodBarrasField() {
        return codBarrasField;
    }

    public JFormattedTextField getValidadeField() {
        return validadeField;
    }

    public JTextField getFornecedorField() {
        return fornecedorField;
    }

    public JButton getAddButton() {
        return addButton;
    }
    
}
