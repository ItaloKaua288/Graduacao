package sistemaBudega.model;

import java.util.ArrayList;
import java.util.Date;

public class BaseDados implements AVencerInterface{
    private static ArrayList<Produto> produtos;
    
    public static void createBase() {
        produtos = new ArrayList<Produto>();
        inicializarBase();
    }

    @SuppressWarnings("deprecation")
    private static void inicializarBase() {
        Fornecedor fornecedor = new Fornecedor("Zé Santos", "111.111.111-11", "01.000.000/0001-11", "Sertão Bebidas");
        
        Produto produto1 = new Produto("Pinga Sertão", "prod001", 1000.0, 800, new Date(2025, 10, 25), fornecedor);
        new Estoque(100, produto1);
        Produto produto2 = new Produto("Feijão", "prod002", 5.0, 1, new Date(2022, 10, 12), fornecedor);
        new Estoque(100, produto2);
        Produto produto3 = new Produto("Picanha", "prod003", 60.0, 1, new Date(2022, 9, 1), fornecedor);
        new Estoque(50, produto3);
        Produto produto4 = new Produto("Danone", "prod004", 12.0, 1, new Date(2022, 9, 1), fornecedor);
        new Estoque(10, produto4);

        fornecedor.getProdutos().add(produto1);
        fornecedor.getProdutos().add(produto2);
        fornecedor.getProdutos().add(produto3);
        fornecedor.getProdutos().add(produto4);
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
    }

    public static Produto buscarProduto(String codBarras) throws ProdutoNaoExisteException{
        if (codBarras.isBlank())
            throw new ProdutoNaoExisteException();
        
        for (Produto currentProduto : produtos)
            if (currentProduto.getCodBarras().equals(codBarras))
                return currentProduto;
        throw new ProdutoNaoExisteException();
    }

    public static ArrayList<Produto> buscarProdutoAVencer(int diasAVencer) {
        ArrayList<Produto> produtosAVencer = new ArrayList<Produto>();

        for (Produto currentProduto : produtos) {
            long diasAVencerProduto = AVencerInterface.diasAVencer(currentProduto);
            if (diasAVencerProduto <= diasAVencer && diasAVencerProduto > 0)
                produtosAVencer.add(currentProduto);
        }
        return produtosAVencer;
    }

    public static ArrayList<Produto> buscarProdutosVencidos() {
        ArrayList<Produto> produtosVencidos = new ArrayList<Produto>();

        for (Produto currentProduto : produtos)
            if (AVencerInterface.diasAVencer(currentProduto) <= 0)
                produtosVencidos.add(currentProduto);
        return produtosVencidos;
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
