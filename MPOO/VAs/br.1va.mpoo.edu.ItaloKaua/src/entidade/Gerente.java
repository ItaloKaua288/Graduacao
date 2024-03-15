package entidade;

public class Gerente extends Funcionario{

    public Gerente(String nome, String cpf) {
        super(nome, cpf);
    }

    public void darDesconto(Produto produto, int desconto) {}

    public void darDesconto(Compra compra, int desconto) {}

    @Override
    public void calcularSalario() {
    }
    
}
