package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.CampanhaAdocaoRotina;
import view.CadastroView;
import view.IndexView;
import view.MensagemView;

public class IndexController {
	private IndexView indexView;
	private CadastroView cadastroView;
	private ButtonHandler buttonHandler;
	private KeyHandler keyHandler;
	private CampanhaAdocaoRotina bot;
	
	public IndexController(IndexView indexView, CadastroView cadastroView, CampanhaAdocaoRotina bot) {
		super();
		this.indexView = indexView;
		this.cadastroView = cadastroView;
		this.bot = bot;
		this.buttonHandler = new ButtonHandler();
		this.keyHandler = new KeyHandler();
		controle();
	}
	
	public void controle() {
		indexView.participarButton.addActionListener(buttonHandler);
		indexView.participarButton.addKeyListener(keyHandler);
	}
	
	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==indexView.participarButton) {
				cadastroView.setVisible(true);
				indexView.setVisible(false);
			}
			
		}
		
	}
	
	public class KeyHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				if(MensagemView.exibirMensagemEncerrarSistema()==0)	{
					bot.desligar();
					System.exit(0);
				}
			}
			
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				cadastroView.setVisible(true);
				indexView.setVisible(false);
			}
			super.keyPressed(e);
		}
	}
}
