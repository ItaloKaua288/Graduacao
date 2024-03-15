package entidade;

import java.util.ArrayList;

import base.BaseDados;
import gui.Mensagem;

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
        Produto produtoTemp = BaseDados.buscarProduto(produto.codBarras);
        if (produtoTemp.getEstoque().getQuantidade() > 0)
            produtoTemp.getEstoque().setQuantidade(produtoTemp.getEstoque().getQuantidade()-1);
        else {
            Mensagem.exibirMensagem(Mensagem.PRODUTO_INSUFICIENTE);
        }
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
