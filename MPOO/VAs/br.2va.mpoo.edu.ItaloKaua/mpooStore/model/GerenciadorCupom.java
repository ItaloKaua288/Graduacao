package model;

public class GerenciadorCupom {
    private boolean ofertaCupom;
    private int valorCupomAtual;
    public final static String CODIGO_CUPOM = "MPOOSTOREOFF";

    public boolean isOfertaCupom() {
        return ofertaCupom;
    }
    public void setOfertaCupom(boolean ofertaCupom) {
        this.ofertaCupom = ofertaCupom;
    }
    public int getValorCupomAtual() {
        return valorCupomAtual;
    }
    public void setValorCupomAtual(int valorCupomAtual) {
        this.valorCupomAtual = valorCupomAtual;
    }
    
}
