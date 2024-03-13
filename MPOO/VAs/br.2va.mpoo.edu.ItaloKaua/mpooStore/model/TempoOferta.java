package model;

public class TempoOferta extends Thread{
    private final static long TEMPO_OFERTA = 600000;
    private CupomDesconto cupomDesconto;

    public TempoOferta(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

    public void run() {
        while (true) {
            try {
                sleep(TEMPO_OFERTA);
                cupomDesconto.getGerenciadorCupom().setOfertaCupom(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
