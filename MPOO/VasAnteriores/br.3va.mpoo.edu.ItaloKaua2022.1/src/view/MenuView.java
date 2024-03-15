package view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuView extends JFrame{
    private JLabel logoLabel;
    private JButton cadastrarButton, logarButton, sairButton;

    public MenuView() {
        super("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(250, 170);
        setResizable(false);
        setLayout(new FlowLayout());

        logoLabel = new JLabel(new ImageIcon("img//logo.png"));
        cadastrarButton = new JButton("Cadastrar");
        logarButton = new JButton("Logar");
        sairButton = new JButton("Sair");

        add(logoLabel);
        add(cadastrarButton);
        add(logarButton);
        add(sairButton);

        setVisible(true);
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JButton getLogarButton() {
        return logarButton;
    }

    public JButton getSairButton() {
        return sairButton;
    }
    
}
