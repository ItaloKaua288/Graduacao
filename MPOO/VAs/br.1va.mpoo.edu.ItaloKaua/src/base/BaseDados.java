package base;

import java.util.ArrayList;
import java.util.Calendar;

import entidade.Estoque;
import entidade.Produto;
import gui.Mensagem;
import util.Verificador;

public class BaseDados {
    private static ArrayList<Produto> produtos;

    public static void createBase() {
        produtos = new ArrayList<Produto>();
        inicializarBase();
    }

    public static void inicializarBase() {
        Calendar validade = Calendar.getInstance();

        validade.set(2024, Calendar.DECEMBER, 31);
        addProduto(new Produto("PROD001", "feijão da Serra", 10.0, validade, false));

        validade.set(2024, Calendar.MAY, 1);
        addProduto(new Produto("PROD002", "arroz da Serra", 5.0, validade, false));

        validade.set(2023, Calendar.OCTOBER, 12);
        addProduto(new Produto("PROD003", "biscoito formoso", 2.0, validade, false));

        validade.set(2023, Calendar.DECEMBER, 21);
        addProduto(new Produto("PROD004", "laranja mimosa", 0.5, validade, true));
        
        for (int i = 0; i < produtos.size(); i++) {
            produtos.get(i).getEstoque().setQuantidade(100);
        }
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
        if (produto == null || Verificador.isVencido(produto)) {
            Mensagem.exibirMensagem(Mensagem.PRODUTO_ERRO);
            return false;
        }
        
        if (isProduto(produto.codBarras)) {
            Estoque estoqueTemp = BaseDados.buscarProduto(produto.codBarras).getEstoque();
            estoqueTemp.setQuantidade(estoqueTemp.getQuantidade() + produto.getEstoque().getQuantidade());
        } else
            produtos.add(produto);
        Mensagem.exibirMensagem(Mensagem.PRODUTO_SUCESSO);
        return true;
    }

    public static boolean removerProduto(Produto produto) {
        if (produto == null)
            return false;
        
        if (isProduto(produto.codBarras)) {
            return produtos.remove(buscarProduto(produto.codBarras));
        }
        return false;
    }

    public static ArrayList<String> exibirProdutos() {
        ArrayList<String> lista = new ArrayList<String>();

        for (Produto currentProduto : produtos)
            lista.add(currentProduto.getNome());
        return lista;
    }
}
