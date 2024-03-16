package model;

public class Telefone {
    private int ddi;
    private int ddd;
    private int numero;

    public Telefone(Pessoa pessoa) {
        pessoa.getTelefones().add(this);
    }

    public Telefone(int ddi, int ddd, String numero, Pessoa pessoa) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = Integer.parseInt(numero.replace("-", ""));
        pessoa.getTelefones().add(this);
    }

    public int getDdi() {
        return ddi;
    }

    public int getDdd() {
        return ddd;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "+" + ddi + " (" + ddd + ") " + numero;
    }
    
    
}
