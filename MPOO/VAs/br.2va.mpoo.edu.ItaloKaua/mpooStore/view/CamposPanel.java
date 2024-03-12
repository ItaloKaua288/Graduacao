package view;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import util.SpringUtilities;

public class CamposPanel extends JPanel{
    private JLabel nomeLabel, cpfLabel, emailLabel;

    public CamposPanel(JTextField nomeField, JTextField emailField, JFormattedTextField cpField) {
        setLayout(new SpringLayout());

        nomeLabel = new JLabel("Nome:");
        cpfLabel = new JLabel("CPF:");
        emailLabel = new JLabel("Email:");

        add(nomeLabel);
        add(nomeField);
        add(cpfLabel);
        add(cpField);
        add(emailLabel);
        add(emailField);

        SpringUtilities.makeCompactGrid(this, 3, 2, 5, 0, 5, 5);
    }
}
