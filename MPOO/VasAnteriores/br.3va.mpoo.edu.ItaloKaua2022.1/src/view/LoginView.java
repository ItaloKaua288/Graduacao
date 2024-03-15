package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginView extends JFrame{
    private JLabel loginLabel, senhaLabel;
    private JTextField loginField, senhaField;
    private JButton entrarButton, voltarButton;

    public LoginView() {
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setSize(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        loginLabel = new JLabel("Login:");
        senhaLabel = new JLabel("Senha:");
        loginField = new JTextField(12);
        loginField.setPreferredSize(new Dimension(0, 25));
        senhaField = new JTextField(12);
        senhaField.setPreferredSize(new Dimension(0, 25));
        entrarButton = new JButton("Entrar");
        voltarButton = new JButton("Voltar");

        add(loginLabel);
        add(loginField);
        add(senhaLabel);
        add(senhaField);
        add(entrarButton);
        add(voltarButton);

        setVisible(true);
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JTextField getSenhaField() {
        return senhaField;
    }

    public JButton getEntrarButton() {
        return entrarButton;
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }
    
}
