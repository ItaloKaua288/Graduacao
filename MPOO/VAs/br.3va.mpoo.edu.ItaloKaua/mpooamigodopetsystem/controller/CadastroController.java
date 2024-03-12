package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.BaseDados;
import model.CadastroException;
import model.MensagemModel;
import model.Proprietario;
import model.Telefone;
import view.CadastroView;
import view.IndexView;
import view.MensagemView;

public class CadastroController implements ActionListener {
	private CadastroView cadastroView;
	private IndexView indexView;
	private WindowHandler windowHandler;

	public CadastroController(CadastroView cadastroView, IndexView indexView) {
		super();
		this.cadastroView = cadastroView;
		this.indexView = indexView;
		this.windowHandler = new WindowHandler();
		controle();
	}

	public void controle() {
		cadastroView.cadastrarButton.addActionListener(this);
		cadastroView.addWindowListener(windowHandler);
	}

	public class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			if (e.getSource() == cadastroView) {
				cadastroView.setVisible(false);
				indexView.setVisible(true);
			}
			super.windowClosed(e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nome = cadastroView.nomeField.getText();
		String cpf = cadastroView.cpfField.getText().replace(".", "").replace("-", "");
		String email = cadastroView.emailField.getText();
		String fone = cadastroView.foneField.getText().replace("+", "").replace("(", "").replace(")", "").replace("-", "");
		boolean whatsapp = cadastroView.whatsappCheckBox.isSelected();
		String animalPreferido = cadastroView.animalPreferidoField.getText();
		String disponibilidade = cadastroView.disponibilidadeField.getText();
		boolean contato = cadastroView.contatoCheckBox.isSelected();
		boolean voluntario = cadastroView.simRadioButton.isSelected();

		if (nome.isBlank() || cpf.isBlank() || email.isBlank() || animalPreferido.isBlank() || disponibilidade.isBlank()
				|| fone.isBlank()) {
			MensagemView.exibirMensagem("Preencha todos os campos!");
			return;
		}

		int foneDdi = Integer.parseInt(fone.split(" ")[0]);
		int foneDdd = Integer.parseInt(fone.split(" ")[1]);
		String foneNum = fone.split(" ")[2];

		try {
			Proprietario proprietario = new Proprietario(nome, cpf, email, animalPreferido, voluntario);
			proprietario.whatsapp = whatsapp;
			proprietario.contato = contato;
			new Telefone(proprietario, foneDdi, foneDdd, foneNum);
			proprietario.setDisponibilida(disponibilidade);
			BaseDados.addPessoa(proprietario);
			MensagemView.exibirMensagem(MensagemModel.CADASTRO_SUCESSO);
		} catch (CadastroException e1) {
			e1.printStackTrace();
		}

	}
}
