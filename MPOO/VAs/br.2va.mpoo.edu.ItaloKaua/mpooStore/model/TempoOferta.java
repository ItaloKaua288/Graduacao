package model;

public class TempoOferta extends Thread{
    private final static long TEMPO_OFERTA = 600000;

    public TempoOferta() {}

    public void run() {
        while (true) {
            try {
                
                sleep(TEMPO_OFERTA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
