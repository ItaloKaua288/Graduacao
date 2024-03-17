package sistemaBudega.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class AVencer extends JFrame{
    private JLabel prazoLabel;
    private JTextField prazoField;
    private JButton buscarButton;

    public AVencer() {
        super("A Vencer");
        setSize(190, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        prazoLabel = new JLabel("Prazo (dias):");
        prazoField = new JTextField(5);
        buscarButton = new JButton("Buscar");

        add(prazoLabel);
        add(prazoField);
        add(buscarButton);
    }

    public JTextField getPrazoField() {
        return prazoField;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    
}
