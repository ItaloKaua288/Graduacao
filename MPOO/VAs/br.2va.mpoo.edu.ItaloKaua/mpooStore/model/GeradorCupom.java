package model;

import java.util.Random;

public class GeradorCupom extends Thread{
    private final static long GERAR_CUPOM = 5000;
    private GerenciadorCupom gerenciadorCupom;

    public GeradorCupom(GerenciadorCupom gerenciadorCupom) {
        this.gerenciadorCupom = gerenciadorCupom;
    }

    private int gerarCupom() {
        return new Random().nextInt(100);
    }

    public void run() {
        while (true) {
            try {
                gerenciadorCupom.setValorCupomAtual(gerarCupom());

                sleep(GERAR_CUPOM);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
