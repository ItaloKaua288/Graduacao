package view;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import util.SpringUtilities;

@SuppressWarnings("serial")
public class CamposPanel extends JPanel {
	public JLabel nomeLabel, cpfLabel, foneLabel, whatsappLabel, animalPreferidoLabel, voluntarioLabel,
			disponibilidadeLabel, emailLabel;
	public JTextField nomeField, emailField, animalPreferidoField, disponibilidadeField;
	public JFormattedTextField cpfField, foneField;
	public JCheckBox whatsappCheckBox;
	public JRadioButton simRadioButton, naoRadioButton;
	public JPanel radioPanel;

	public CamposPanel(JLabel nomeLabel, JLabel cpfLabel, JLabel foneLabel, JLabel whatsappLabel,
			JLabel animalPreferidoLabel, JLabel voluntarioLabel, JLabel disponibilidadeLabel, JLabel emailLabel,
			JTextField nomeField, JTextField emailField, JTextField animalPreferidoField,
			JTextField disponibilidadeField, JFormattedTextField cpfField, JFormattedTextField foneField,
			JCheckBox whatsappCheckBox, JRadioButton simRadioButton, JRadioButton naoRadioButton) {
		setLayout(new SpringLayout());

		this.nomeLabel = nomeLabel;
		this.cpfLabel = cpfLabel;
		this.foneLabel = foneLabel;
		this.whatsappLabel = whatsappLabel;
		this.animalPreferidoLabel = animalPreferidoLabel;
		this.voluntarioLabel = voluntarioLabel;
		this.disponibilidadeLabel = disponibilidadeLabel;
		this.emailLabel = emailLabel;
		this.nomeField = nomeField;
		this.emailField = emailField;
		this.animalPreferidoField = animalPreferidoField;
		this.disponibilidadeField = disponibilidadeField;
		this.cpfField = cpfField;
		this.foneField = foneField;
		this.whatsappCheckBox = whatsappCheckBox;
		this.simRadioButton = simRadioButton;
		this.naoRadioButton = naoRadioButton;

		radioPanel = new JPanel();

		add(nomeLabel);
		add(nomeField);
		add(cpfLabel);
		add(cpfField);
		add(emailLabel);
		add(emailField);
		add(foneLabel);
		add(foneField);
		add(whatsappLabel);
		add(whatsappCheckBox);
		add(animalPreferidoLabel);
		add(animalPreferidoField);
		add(voluntarioLabel);
		radioPanel.add(simRadioButton);
		radioPanel.add(naoRadioButton);
		add(radioPanel);
		add(disponibilidadeLabel);
		add(disponibilidadeField);

		SpringUtilities.makeCompactGrid(this, 8, 2, 5, 5, 0, 0);
	}

}
