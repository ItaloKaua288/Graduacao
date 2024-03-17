package sistemaBudega.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DescontoView extends JFrame{
    private JLabel tituloLabel, codBarrasLabel, descontoLabel, prazoLabel;
    private JTextField codBarrasField, descontoField;
    private JRadioButton codBarrasRadioButton, validadeRadioButton;
    private JComboBox<String> prazComboBox;
    private JButton aplicarButton;

    public DescontoView() {
        super("Gerenciar Desconto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(190, 200);
        setResizable(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tituloLabel = new JLabel("Critério:");
        tituloLabel.setFont(new Font("", Font.BOLD, 20));
        tituloLabel.setPreferredSize(new Dimension(189, 30));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        codBarrasRadioButton = new JRadioButton("Código Barras", true);
        codBarrasRadioButton.setFont(new Font("", ABORT, 11));
        validadeRadioButton = new JRadioButton("Validade");
        validadeRadioButton.setFont(new Font("", ABORT, 11));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(codBarrasRadioButton);
        buttonGroup.add(validadeRadioButton);

        codBarrasLabel = new JLabel("Código Barras:");
        codBarrasField = new JTextField(5);

        String[] dias = new String[100];
        for (int i = 1; i < 100; i++)
            dias[i] = i+"";
        prazoLabel = new JLabel("Prazo (dias)");
        prazoLabel.setVisible(false);
        prazComboBox = new JComboBox<>(dias);
        prazComboBox.setVisible(false);

        descontoLabel = new JLabel("Desconto (%):");
        descontoField = new JTextField(3);

        aplicarButton = new JButton("Aplicar");

        add(tituloLabel);
        add(codBarrasRadioButton);
        add(validadeRadioButton);
        add(codBarrasLabel);
        add(codBarrasField);
        add(prazoLabel);
        add(prazComboBox);
        add(descontoLabel);
        add(descontoField);
        add(aplicarButton);
    }

    public JLabel getCodBarrasLabel() {
        return codBarrasLabel;
    }

    public JLabel getPrazoLabel() {
        return prazoLabel;
    }

    public JTextField getCodBarrasField() {
        return codBarrasField;
    }

    public JTextField getDescontoField() {
        return descontoField;
    }

    public JRadioButton getCodBarrasRadioButton() {
        return codBarrasRadioButton;
    }

    public JRadioButton getValidadeRadioButton() {
        return validadeRadioButton;
    }

    public JComboBox<String> getPrazComboBox() {
        return prazComboBox;
    }

    public JButton getAplicarButton() {
        return aplicarButton;
    }
    
}
