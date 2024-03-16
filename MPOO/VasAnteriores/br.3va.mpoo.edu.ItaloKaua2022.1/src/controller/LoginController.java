package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import model.BaseDados;
import model.Log;
import model.Mensagem;
import model.Usuario;
import view.LoginView;
import view.MensagemView;
import view.MenuView;

public class LoginController {
    private MenuView menuView;
    private LoginView loginView;
    private ButtonHandler buttonHandler;

    public LoginController(MenuView menuView, LoginView loginView) {
        this.menuView = menuView;
        this.loginView = loginView;
        this.buttonHandler = new ButtonHandler();

        controle();
    }

    private void controle() {
        loginView.getEntrarButton().addActionListener(buttonHandler);
        loginView.getVoltarButton().addActionListener(buttonHandler);
    }

    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loginView.getEntrarButton()) {
                String login = loginView.getLoginField().getText();
                String senha = loginView.getSenhaField().getText();

                if(!BaseDados.isUsuario(login, senha)) {
                    MensagemView.exibirMensagemErro(Mensagem.USUARIO_LOGIN_ERROR);
                    return;
                }

                Usuario usuarioTemp = new Usuario(login, senha);
                usuarioTemp.setLastLogin(LocalDateTime.now());
                Log.getUsuariosLogados().add(usuarioTemp);
                MensagemView.exibirMensagem(Mensagem.USUARIO_LOGIN_SUCESS);
            }

            if(e.getSource() == loginView.getVoltarButton()) {
                loginView.setVisible(false);
                menuView.setVisible(true);
            }
        }

    }
    
}
