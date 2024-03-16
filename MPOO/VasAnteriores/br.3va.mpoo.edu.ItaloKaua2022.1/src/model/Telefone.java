package model;

public class Telefone {
    private int ddi;
    private int ddd;
    private int numero;

    public Telefone(Pessoa pessoa) {
        pessoa.getTelefones().add(this);
    }

    public Telefone(int ddi, int ddd, int numero, Pessoa pessoa) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
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
    
    
}
