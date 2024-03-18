package model;

import java.util.ArrayList;

public class BaseDados implements Verificador{
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();

    public static boolean addProduto(Produto produto) throws ProdutoException{
        if (produto == null)
            return false;
        
        if (exiteProduto(produto))
            throw new ProdutoException();
        
        return produtos.add(produto);
    }

    public static boolean exiteProduto(Produto produto) {
        if (produto == null) 
            return false;
        
        boolean contains = false;
        if (produtos.contains(produto)) contains = true;

        return contains;
    }

    public static ArrayList<Produto> buscarProdutoVencido() {
        ArrayList<Produto> produtosVencidos = new ArrayList<Produto>();

        for (Produto currentProduto : produtos)
            if (!Verificador.verificarValidade(currentProduto))
                produtosVencidos.add(currentProduto);
        return produtosVencidos;
    }

    public static String consultarDadosProduto(Produto produto) {
        if (!exiteProduto(produto))
            return "";

        for (Produto currentProduto : produtos)
            if (currentProduto.getCodBarras().equals(produto.getCodBarras()))
                return currentProduto.toString();
        return "";
    }

    public static ArrayList<String> listProdutos() {
        ArrayList<String> lista = new ArrayList<String>();

        for (Produto currentProduto : produtos)
            lista.add(currentProduto.getNome() + "(" + currentProduto.getCodBarras() + ")");
        return lista;
    }
}
