package entidade;

public class Vendedor extends Funcionario{
    public final double COMISSAO = 0.05;
    private double totalComissao;
    private String codVendedor;

    public Vendedor(String nome, String cpf, String codVendedor) {
        super(nome, cpf);
        this.codVendedor = codVendedor;
    }

    @Override
    public void calcularSalario() {

    }

    @Override
    public String toString() {
        return "Vendedor [" + super.toString() + " totalComissao=" + totalComissao + ", codVendedor=" + codVendedor + "]";
    }

    public double getTotalComissao() {
        return totalComissao;
    }

    public String getCodVendedor() {
        return codVendedor;
    }
    
    
}
