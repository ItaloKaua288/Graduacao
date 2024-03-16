import controller.CadastroController;
import controller.LoginController;
import controller.MenuController;
import model.BaseDados;
import model.SuperUsuario;
import view.CadastroView;
import view.LoginView;
import view.MenuView;

public class App {
    public static void main(String[] args) {
        BaseDados.createBase();

        MenuView menuView = new MenuView();
        LoginView loginView = new LoginView();
        CadastroView cadastroView = new CadastroView();

        new MenuController(menuView, cadastroView, loginView);
        new CadastroController(menuView, cadastroView);
        new LoginController(menuView, loginView);

        SuperUsuario SuperUsuario = new SuperUsuario();
    }
}
