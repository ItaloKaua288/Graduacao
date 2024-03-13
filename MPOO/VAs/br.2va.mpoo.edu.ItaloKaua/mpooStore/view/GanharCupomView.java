package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class GanharCupomView extends JFrame{
    private JLabel logoLabel, cupomLabel, brindeLabel;
    private JTextField nomeField, emailField;
    private JFormattedTextField cpfField;
    private JButton confirmarButton;
    private JPanel camposPanel, brindePanel;

    public GanharCupomView() {
        super("MPOOStore");
        setIconImage(new ImageIcon("mpooStore.img/icone.png").getImage());
        setLocationRelativeTo(null);
        setSize(300, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        logoLabel = new JLabel(new ImageIcon("mpooStore.img/logo.png"));
        confirmarButton = new JButton("Confirmar");

        nomeField = new JTextField();
        emailField = new JTextField();
        try {
            cpfField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        camposPanel = new CamposPanel(nomeField, emailField, cpfField);

        brindePanel = new JPanel(new FlowLayout());
        cupomLabel = new JLabel("Cupom Desconto");
        brindeLabel = new JLabel(new ImageIcon("mpooStore.img/brinde.png"));
        brindePanel.add(cupomLabel);
        brindePanel.add(brindeLabel);

        add(logoLabel, BorderLayout.NORTH);
        add(camposPanel, BorderLayout.CENTER);
        add(confirmarButton, BorderLayout.EAST);
        add(brindePanel, BorderLayout.SOUTH);
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JFormattedTextField getCpfField() {
        return cpfField;
    }

    public JButton getConfirmarButton() {
        return confirmarButton;
    }
    
}
