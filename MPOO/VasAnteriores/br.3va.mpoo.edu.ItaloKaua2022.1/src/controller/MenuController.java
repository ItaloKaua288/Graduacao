package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CadastroView;
import view.LoginView;
import view.MenuView;

public class MenuController {
    private MenuView menuView;
    private CadastroView cadastroView;
    private LoginView loginView;

    public MenuController(MenuView menuView, CadastroView cadastroView, LoginView loginView) {
        this.menuView = menuView;
        this.cadastroView = cadastroView;
        this.loginView = loginView;

        controle();
    }

    private void controle() {
        menuView.getCadastrarButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.setVisible(false);
                cadastroView.setVisible(true);
            }
        });

        menuView.getLogarButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.setVisible(false);
                loginView.setVisible(true);
            }
        });

        menuView.getSairButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
    }
}
