package base;

import java.util.ArrayList;

import entidade.Produto;
import gui.Mensagem;

public class BaseDados {
    private static ArrayList<Produto> produtos;

    public static void createBase() {
        produtos = new ArrayList<Produto>();
        inicializarBase();
    }

    public static void inicializarBase() {

    }

    public static Produto buscarProduto(String codBarras) {
        if (codBarras.isBlank() || codBarras == null)
            return null;

        for (Produto currentProduto : produtos) {
            if (currentProduto.codBarras.equals(codBarras))
                return currentProduto;
        }
        return null;
    }

    public static boolean isProduto(String codBarras) {
        if (codBarras.isBlank() || codBarras == null)
            return false;

        boolean contains = false;
        if (buscarProduto(codBarras) != null) contains = true;

        return contains;
    }

    public static boolean addProduto(Produto produto) {
        if (produto == null)
            return false;
        
        if (isProduto(produto.codBarras)) {
            Mensagem.exibirMensagem(Mensagem.PRODUTO_ERRO);
            return false;
        }
        
        Mensagem.exibirMensagem(Mensagem.PRODUTO_SUCESSO);
        return produtos.add(produto);
    }

    public static boolean removerProduto(Produto produto) {
        if (produto == null)
            return false;
        
        if (isProduto(produto.codBarras))
            return produtos.remove(buscarProduto(produto.codBarras));
        return false;
    }

    public static ArrayList<String> exibirProdutos() {
        ArrayList<String> lista = new ArrayList<String>();

        for (Produto currentProduto : produtos)
            lista.add(currentProduto.getNome());
        return lista;
    }
}
