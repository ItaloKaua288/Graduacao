package model;

import java.time.LocalDateTime;

public class Usuario extends Pessoa implements SuperUsuario{
    public static final int TEMPO_LOG = 5;
    public String login;
    private String senha;
    private LocalDateTime lastLogin;

    public Usuario(String nome, String cpf, String sexo, String login, String senha) throws CPFException {
        super(nome, cpf, sexo);
        this.login = login;
        this.senha = senha;
        this.lastLogin = LocalDateTime.now();
    }

    public Usuario(String nome, String cpf, String sexo, String login) throws CPFException {
        super(nome, cpf, sexo);
        this.login = login;
        this.senha = "123";
        this.lastLogin = LocalDateTime.now();
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
    
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "Usuario [" + super.toString() + ", login=" + login + ", senha=" + senha + "]";
    }
    
}
