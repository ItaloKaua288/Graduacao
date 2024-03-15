package entidade;

public class Vendedor extends Funcionario{
    public final double COMISSAO = 0.05;
    private double totalComissao;
    private String codVendedor;

    public Vendedor(String nome, String cpf, String codVendedor) {
        super(nome, cpf);
        this.codVendedor = codVendedor;
        calcularSalario();
    }

    @Override
    public void calcularSalario() {
        setSalario(SALARIO_MINIMO + (totalComissao*COMISSAO));
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

    public void setTotalComissao(double totalComissao) {
        this.totalComissao = totalComissao;
    }
    
}
