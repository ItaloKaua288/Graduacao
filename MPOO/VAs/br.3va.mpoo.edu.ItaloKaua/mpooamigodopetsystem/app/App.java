package app;


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controller.CadastroController;
import controller.IndexController;
import model.BaseDados;
import model.CadastroException;
import model.CampanhaAdocaoRotina;
import view.CadastroView;
import view.IndexView;

public class App {
	public static void main(String[] args) throws CadastroException {
		try {
			LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
			for (LookAndFeelInfo look : looks)
				if (look.getName().contains("Nimbus"))
					UIManager.setLookAndFeel(look.getClassName());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Não foi possivel usar o Look And Fells");
		}

		BaseDados baseDados = new BaseDados();
		try {
			BaseDados.createBase();
		} catch (CadastroException e) {
			e.printStackTrace();
			throw e;
		}
		System.out.println("Proprietario: " + BaseDados.listEmailProprietarios());
		System.out.println("Voluntarios" + BaseDados.listEmailVoluntarios());
		System.out.println("Animais preferidos: " + BaseDados.listAnimaisPreferidos());

		CampanhaAdocaoRotina bot = new CampanhaAdocaoRotina(baseDados);
		bot.start();

		IndexView indexView = new IndexView();
		CadastroView cadastroView = new CadastroView();

		new IndexController(indexView, cadastroView, bot);
		new CadastroController(cadastroView, indexView);
	}
}
