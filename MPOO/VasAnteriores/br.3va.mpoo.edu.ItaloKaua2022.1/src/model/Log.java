package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import view.MensagemView;

public class Log extends Thread{
    private static ArrayList<Usuario> usuariosLogados;

    public Log() {
        usuariosLogados = new ArrayList<Usuario>();
    }

    private void deslogar() {
        ArrayList<Usuario> usuariosRemover = new ArrayList<Usuario>();
		long timeCurrentSystem;
		for (Usuario userCurrent:usuariosLogados){
			timeCurrentSystem=userCurrent.getLastLogin().until(LocalDateTime.now(), ChronoUnit.SECONDS);
			if (userCurrent instanceof Usuario){
				if (timeCurrentSystem>=userCurrent.TEMPO_LOG){
                    MensagemView.exibirMensagem("Você foi deslogado");
					//JOptionPane.showMessageDialog(null, "Você foi deslogado");
				}
			}
		}
		usuariosLogados.removeAll(usuariosRemover);
    }

    public void run() {
        while (true) {
            try {
                deslogar();
                sleep(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Usuario> getUsuariosLogados() {
        return usuariosLogados;
    }
}
