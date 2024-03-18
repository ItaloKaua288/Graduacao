package app;

import java.util.ArrayList;
import java.util.Date;

import controller.ControladorTelas;
import model.BaseDados;
import model.Produto;
import model.ProdutoException;
import view.TelaCadastro;
import view.TelaMensagem;
import view.TelaMenu;

public class App extends Thread{
    public App() {
        start();
    }
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        TelaMenu telaMenu = new TelaMenu();
        TelaCadastro telaCadastro = new TelaCadastro();

        new ControladorTelas(telaCadastro, telaMenu);

        Produto produto1 = new Produto("feijão", "111000222", new Date(2019, 7, 10), 100);
        Produto produto2 = new Produto("arroz", "222111000", new Date(2019, 7, 14), 50);
        Produto produto3 = new Produto("ovos", "333222111", new Date(2023, 4, 20), 1000);
        try {
            BaseDados.addProduto(produto1);
            BaseDados.addProduto(produto2);
            BaseDados.addProduto(produto3);
        } catch (ProdutoException e) {
            e.printStackTrace();
        }
        
        new App();

    }

    public void run() {
        while (true) {
            try {
                String produtos = "Produto(s) cadastrado(s):\n";
                ArrayList<String> produtosBase = BaseDados.listProdutos();
                for (int i = 0; i < BaseDados.listProdutos().size(); i++)
                    produtos += produtosBase.get(i) + "\n";
                TelaMensagem.exibirMensagem(produtos);

                ArrayList<Produto> vencidos = BaseDados.buscarProdutoVencido();
                String listaVencidos = "Produto(s) vencido(s):\n";
                if (vencidos.size() > 0) {
                    for (int i = 0; i < vencidos.size(); i++)
                        listaVencidos += (vencidos.get(i).getNome() + "(" + vencidos.get(i).getCodBarras() + ")\n");
                    TelaMensagem.exibirMensagem(listaVencidos.toString());
                }
                sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
