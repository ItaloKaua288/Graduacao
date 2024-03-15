package entidade;

public abstract class Funcionario {
    public final static double SALARIO_MINIMO = 1320.0;
    private String nome;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = SALARIO_MINIMO;
    }

    public abstract void calcularSalario();

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + "]";
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
