package entidade;

import java.util.ArrayList;

public class Compra {
    public int id;
    private double valorTotal;
    private ArrayList<Produto> produtos;

    public Compra() {}

    public boolean adicionarProduto(Produto produto) {
        if(produto == null)
            return false;

        return produtos.add(produto);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
