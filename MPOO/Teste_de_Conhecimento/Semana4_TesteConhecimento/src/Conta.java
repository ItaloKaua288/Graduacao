public class Conta {
    private int numero;
    private static final int AGENCIA = 2730;
    private double saldo;
    private static int cont;

    public Conta() {
        this.numero = cont++;
    }

    public Conta(double saldo) {
        this.saldo = saldo;
        this.numero = cont++;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getAgencia() {
        return AGENCIA;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
