package entidade;

public class Caixa extends Funcionario{

    public Caixa(String nome, String cpf) {
        super(nome, cpf);
    }

    public void registrarVenda(Compra compra, Produto produto, String codVendedor) {
        Vendedor vendedor = Supermercado.buscarVendedor(codVendedor);
        
        Compra compraTemp = null;
        if (compra != null)
            compraTemp = compra;

        if (produto != null) {
            compraTemp = new Compra();
            compraTemp.adicionarProduto(produto);
        }

        Supermercado.compras.add(compraTemp);

        if (vendedor != null) {
            vendedor.setTotalComissao(vendedor.getTotalComissao() + (compraTemp.getValorTotal()*vendedor.COMISSAO));
            vendedor.calcularSalario();
        }
    }

    @Override
    public void calcularSalario() {}
    
}
