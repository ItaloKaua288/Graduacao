package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class CadastroView extends JFrame{
    private JLabel tituloLabel, nomeLabel, loginLabel, cpfLabel, senhaLabel, sexoLabel, telefoneLabel;
    private JTextField nomeField, loginField, senhaField, ddiField, dddField, numeroField;
    private JFormattedTextField cpField;
    private JButton cadastrarButton, voltarButton;
    private JRadioButton eleRadioButton, elaRadioButton;

    public CadastroView() {
        setUndecorated(true);
        setSize(155, 380);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));

        tituloLabel = new JLabel("Cadastrar");
        tituloLabel.setFont(new Font("", Font.BOLD, 25));

        nomeLabel = new JLabel("Nome");
        nomeField = new JTextField(13);
        nomeField.setPreferredSize(new Dimension(0, 25));

        loginLabel = new JLabel("Login");
        loginField = new JTextField(13);
        loginField.setPreferredSize(new Dimension(0, 25));

        cpfLabel = new JLabel("CPF");
        try {
            cpField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
            cpField.setColumns(13);
            cpField.setPreferredSize(new Dimension(0, 25));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        senhaLabel = new JLabel("Senha");
        senhaField = new JTextField(13);
        senhaField.setPreferredSize(new Dimension(0, 25));

        sexoLabel = new JLabel("Sexo:");
        eleRadioButton = new JRadioButton("Ele", true);
        elaRadioButton = new JRadioButton("Ela");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(eleRadioButton);
        buttonGroup.add(elaRadioButton);

        telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setPreferredSize(new Dimension(154, 10));
        telefoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ddiField = new JTextField("ddi");
        dddField = new JTextField("ddd");
        numeroField = new JTextField("99999-9999");

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(new Font("", Font.BOLD, 10));
        voltarButton = new JButton("Voltar");
        voltarButton.setFont(new Font("", Font.BOLD, 10));

        add(tituloLabel);
        add(nomeLabel);
        add(nomeField);
        add(loginLabel);
        add(loginField);
        add(cpfLabel);
        add(cpField);
        add(senhaLabel);
        add(senhaField);
        add(sexoLabel);
        add(eleRadioButton);
        add(elaRadioButton);
        add(telefoneLabel);
        add(ddiField);
        add(dddField);
        add(numeroField);
        add(cadastrarButton);
        add(voltarButton);

        setVisible(true);
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JTextField getSenhaField() {
        return senhaField;
    }

    public JTextField getDdiField() {
        return ddiField;
    }

    public JTextField getDddField() {
        return dddField;
    }

    public JTextField getNumeroField() {
        return numeroField;
    }

    public JFormattedTextField getCpField() {
        return cpField;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }

    public JRadioButton getEleRadioButton() {
        return eleRadioButton;
    }

    public JRadioButton getElaRadioButton() {
        return elaRadioButton;
    }
    
}
