package model;

import view.MensagemView;

@SuppressWarnings("serial")
public class CadastroException extends Exception {
	public CadastroException() {
		super(MensagemModel.CADASTRO_ERROR);
		MensagemView.exibirMensagem(MensagemModel.CADASTRO_ERROR);
	}
}
