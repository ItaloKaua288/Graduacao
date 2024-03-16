package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.CPFException;
import model.Mensagem;
import model.Telefone;
import model.Usuario;
import view.CadastroView;
import view.MensagemView;
import view.MenuView;

public class CadastroController implements ActionListener {
    private MenuView menuView;
    private CadastroView cadastroView;

    public CadastroController(MenuView menuView, CadastroView cadastroView) {
        this.menuView = menuView;
        this.cadastroView = cadastroView;
        controle();
    }

    private void controle() {
        cadastroView.getCadastrarButton().addActionListener(this);
        cadastroView.getVoltarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cadastroView.getVoltarButton()) {
            cadastroView.setVisible(false);
            menuView.setVisible(true);
        }

        if(e.getSource() == cadastroView.getCadastrarButton()) {
            String nome = cadastroView.getNomeField().getText();
            String login = cadastroView.getLoginField().getText();
            String cpf = cadastroView.getCpField().getText().replace(".", "").replace("-", "");
            String senha = cadastroView.getSenhaField().getText();
            
            String sexo;
            if (cadastroView.getEleRadioButton().isSelected())
                sexo = "Masculino";
            else
                sexo = "Feminino";
            
            int ddi, ddd, numero;
            try {
                ddi = Integer.parseInt(cadastroView.getDdiField().getText());
                ddd = Integer.parseInt(cadastroView.getDddField().getText());
                numero = Integer.parseInt(cadastroView.getNumeroField().getText().replace("-", ""));
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
                return;
            }

            if (nome.isBlank() || login.isBlank() || cpf.isBlank() || senha.isBlank()) {
                MensagemView.exibirMensagemErro("O preenchimento de todos os campos é obrigatório!");
                return;
            }

            Usuario usuario = null;
            if (senha.isBlank())
                try {
                    usuario = new Usuario(nome, cpf, sexo, login);
                } catch (CPFException e1) {
                    e1.printStackTrace();
                }
            else
                try {
                    usuario = new Usuario(nome, cpf, sexo, login, senha);
                } catch (CPFException e1) {
                    e1.printStackTrace();
                }
            new Telefone(ddi, ddd, numero, usuario);

            if (BaseDados.adicionarPessoa(usuario))
                MensagemView.exibirMensagem(Mensagem.USUARIO_SUCESS);
            else
                MensagemView.exibirMensagem(Mensagem.USUARIO_ERROR);
        }
    }
    
}
