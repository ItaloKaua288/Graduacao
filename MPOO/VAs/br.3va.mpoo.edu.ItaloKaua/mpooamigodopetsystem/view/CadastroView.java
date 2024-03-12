package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class CadastroView extends JFrame {
	public JLabel tituloLabel, contatoLabel, nomeLabel, cpfLabel, foneLabel, whatsappLabel, animalPreferidoLabel,
			voluntarioLabel, disponibilidadeLabel, emailLabel;
	public JTextField nomeField, emailField, animalPreferidoField, disponibilidadeField;
	public JFormattedTextField cpfField, foneField;
	public JPanel camposPanel;
	public JCheckBox contatoCheckBox, whatsappCheckBox;
	public JButton cadastrarButton;
	public JRadioButton simRadioButton, naoRadioButton;

	public CadastroView() {
		super("MPOOAmigodoPet");
		setSize(400, 350);
		setLayout(new BorderLayout(5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		tituloLabel = new JLabel("Cadastro");
		tituloLabel.setFont(new Font("", Font.BOLD, 20));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

		nomeLabel = new JLabel("Nome:");
		nomeField = new JTextField();
		cpfLabel = new JLabel("CPF:");
		try {
			cpfField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		emailLabel = new JLabel("Email:");
		emailField = new JTextField();
		foneLabel = new JLabel("Fone:");
		try {
			foneField = new JFormattedTextField(new MaskFormatter("+## (##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		whatsappLabel = new JLabel("WhatsApp:");
		whatsappCheckBox = new JCheckBox("Fone � zap", true);
		animalPreferidoLabel = new JLabel("Animal Preferido:");
		animalPreferidoField = new JTextField();
		voluntarioLabel = new JLabel("Ser voluntario");
		simRadioButton = new JRadioButton("Sim", true);
		naoRadioButton = new JRadioButton("N�o");
		ButtonGroup radiosGroup = new ButtonGroup();
		radiosGroup.add(simRadioButton);
		radiosGroup.add(naoRadioButton);
		disponibilidadeLabel = new JLabel("Disponibilidade");
		disponibilidadeField = new JTextField();

		camposPanel = new CamposPanel(nomeLabel, cpfLabel, foneLabel, whatsappLabel, animalPreferidoLabel,
				voluntarioLabel, disponibilidadeLabel, emailLabel, nomeField, emailField, animalPreferidoField,
				disponibilidadeField, cpfField, foneField, whatsappCheckBox, simRadioButton, naoRadioButton);

		cadastrarButton = new JButton("Cadastrar");

		contatoCheckBox = new JCheckBox("Permitido MPOO Amigo Pet entrar em contato!", true);
		contatoLabel = new JLabel();

		add(tituloLabel, BorderLayout.NORTH);
		add(camposPanel, BorderLayout.CENTER);
		add(cadastrarButton, BorderLayout.EAST);
		add(contatoCheckBox, BorderLayout.PAGE_END);
	}
}
