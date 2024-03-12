package view;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

public class AberturaView extends JFrame{
    private JLabel logoLabel, textoLabel, radioTextoLabel;
    private JRadioButton simRadioButton, naoRadioButton;
    private JButton pegarButton;

    public AberturaView() {
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 200);
        setLayout(new FlowLayout());

        logoLabel = new JLabel(new ImageIcon("mpooStore.img/logo.png"));
        textoLabel = new JLabel("Ganhe um Cupom de Desconto");
        radioTextoLabel = new JLabel("Você é cliente de MPOOStore?");
        simRadioButton = new JRadioButton("Sim", true);
        naoRadioButton = new JRadioButton("Não");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(simRadioButton);
        buttonGroup.add(naoRadioButton);
        pegarButton = new JButton("Pegar Cupom");

        add(logoLabel);
        add(textoLabel);
        add(radioTextoLabel);
        add(simRadioButton);
        add(naoRadioButton);
        add(pegarButton);

        setVisible(true);
    }

    public JRadioButton getSimRadioButton() {
        return simRadioButton;
    }

    public JRadioButton getNaoRadioButton() {
        return naoRadioButton;
    }

    public JButton getPegarButton() {
        return pegarButton;
    }
}
