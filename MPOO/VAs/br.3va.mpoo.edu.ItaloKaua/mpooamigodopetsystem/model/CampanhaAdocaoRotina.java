package model;

import view.MensagemView;

public class CampanhaAdocaoRotina extends Thread {
	private final static long INTERVALO_VERIFICADO = 3600000;
	private BaseDados baseDados;

	public CampanhaAdocaoRotina(BaseDados baseDados) {
		this.baseDados = baseDados;
	}

	public void run() {
		while (!baseDados.verificarMeta()) {
			try {
				MensagemView.exibirMensagem("Participe, ainda não atingimos a meta de interessados em adotar um pet!");
				// RAD: matar processo
				sleep(INTERVALO_VERIFICADO);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		MensagemView.exibirMensagem("Atingimos nossa meta. Em breve os pets terão um lar! O sistema sera finalizado!");
	}

	public void desligar() {
		interrupt();
	}
}
