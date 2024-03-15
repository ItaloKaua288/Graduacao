package entidade;

public class Caixa extends Funcionario{

    public Caixa(String nome, String cpf) {
        super(nome, cpf);
    }

    public void registrarVenda(Compra compra, Produto produto, String codVendedor) {}

    @Override
    public void calcularSalario() {
        throw new UnsupportedOperationException("Unimplemented method 'calcularSalario'");
    }
    
}
