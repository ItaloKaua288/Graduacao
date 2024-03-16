package app;

import controller.CadastroController;
import controller.LoginController;
import controller.MenuController;
import model.BaseDados;
import model.CPFException;
import model.Log;
import model.Telefone;
import model.Usuario;
import view.CadastroView;
import view.LoginView;
import view.MenuView;

public class App {
    public static void main(String[] args) {
        BaseDados.createBase();

        new Log();

        MenuView menuView = new MenuView();
        LoginView loginView = new LoginView();
        CadastroView cadastroView = new CadastroView();

        new MenuController(menuView, cadastroView, loginView);
        new CadastroController(menuView, cadastroView);
        new LoginController(menuView, loginView);

        Usuario usuario1 = null;
        Usuario usuario2 = null;
        Usuario usuario3 = null;
        Usuario usuario4 = null;
        Usuario superUsuario = null;
        
        try {
            usuario1 = new Usuario("italo", "352.732.228-00", "Masculino", "italo", "admin");
            new Telefone(55, 87, "99999-9999", usuario1);
            BaseDados.adicionarPessoa(usuario1);
        } catch (CPFException e) {
            e.printStackTrace();
        }

        try {
            usuario2 = new Usuario("Maria Silva", "833.533.163-34", "Feminino", "mariasilva", "mAriA");
            new Telefone(55, 87, "99999-1111", usuario2);
            BaseDados.adicionarPessoa(usuario2);
        } catch (CPFException e) {
            e.printStackTrace();
        }

        try {
            usuario3 = new Usuario("João Silva", "833.533.163-34", "Masculino", "joaoSilva", "joaoSilva");
            new Telefone(55, 87, "99999-2222", usuario3);
            BaseDados.adicionarPessoa(usuario3);
        } catch (CPFException e) {
            e.printStackTrace();
        }
        
        try {
            usuario4 = new Usuario("José Santos", "123.456.789-00", "Masculino", "joseSantos", "joseSantos");
            new Telefone(55, 81, "99999-3333", usuario4);
            BaseDados.adicionarPessoa(usuario4);
        } catch (CPFException e) {
            e.printStackTrace();
        }
        try {
            superUsuario = new Usuario("Godofredo Silva", "358.251.830-27", "Masculino", "admin", "admin");
            new Telefone(55, 87, "99999-4444", superUsuario);
            BaseDados.adicionarPessoa(superUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println(usuario3);
        System.out.println(usuario4);
        System.out.println(superUsuario);
        System.out.println(BaseDados.listPessoas());
        System.out.println(BaseDados.listUsuarios());
        
    }
}
