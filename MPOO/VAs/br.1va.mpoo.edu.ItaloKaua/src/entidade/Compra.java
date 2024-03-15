package entidade;

import java.util.ArrayList;

import base.BaseDados;

public class Compra {
    public int id;
    private double valorTotal;
    private ArrayList<Produto> produtos;
    private static int cont;

    public Compra() {
        this.id = cont++;
        this.produtos = new ArrayList<Produto>();
    }

    public boolean adicionarProduto(Produto produto) {
        if(produto == null || BaseDados.buscarProduto(produto.codBarras).preco == 0)
            return false;

        valorTotal += produto.preco;
        BaseDados.removerProduto(produto);
        return produtos.add(BaseDados.buscarProduto(produto.codBarras));
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
